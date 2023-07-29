package io.wetfloo.flashback.domain.feature.notification

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.mapError
import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.recover
import com.github.michaelbull.result.runCatching
import dagger.hilt.android.qualifiers.ApplicationContext
import io.wetfloo.flashback.R
import io.wetfloo.flashback.data.db.feature.notifications.NotificationsDao
import io.wetfloo.flashback.data.db.feature.notifications.model.NotificationLocal
import io.wetfloo.flashback.data.db.feature.notifications.model.SenderAppLocal
import io.wetfloo.flashback.data.db.feature.notifications.toNotificationDomain
import io.wetfloo.flashback.util.Res
import io.wetfloo.flashback.util.UiErrorException
import io.wetfloo.flashback.util.mapIter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotificationsRepository @Inject constructor(
    private val notificationsDao: NotificationsDao,
    @ApplicationContext private val context: Context,
) {
    fun observeNotifications(): Flow<List<NotificationDomain>> =
        notificationsDao
            .observeNotificationsWithSenders()
            .mapIter { notificationRelation ->
                notificationRelation.toNotificationDomain()
            }

    suspend fun saveNotification(
        content: String,
        senderAppPackageName: String,
    ) {
        val notificationLocal = NotificationLocal(
            content = content,
            senderAppId = senderAppPackageName,
        )
        val senderAppNameResult = getAppName(packageName = senderAppPackageName)
            .onFailure { acquisitionError ->
                Log.w(
                    TAG,
                    "Couldn't get app with a package name: ${acquisitionError.packageName} because of ${acquisitionError.cause}"
                )
            }
            .recover { acquisitionError ->
                acquisitionError.packageName
            }


        val senderAppLocal = SenderAppLocal(
            appName = senderAppNameResult.value,
            appPackageName = senderAppPackageName,
        )
        // TODO: this will save the new app name even if it's not available
        //  all of a sudden.
        notificationsDao.saveNotificationWithSenderApp(
            notification = notificationLocal,
            senderApp = senderAppLocal,
        )
    }

    // TODO: query apps for the actual package name
    //  (this might be inefficient, since app names don't change often)
    private fun getAppName(packageName: String): Result<String, AppNameAcquisitionException> =
        runCatching {
            val packageManager = context.packageManager
            val appInfo = packageManager.getApplicationInfo(
                packageName,
                PackageManager.GET_META_DATA,
            )
            packageManager.getApplicationLabel(appInfo).toString()
        }.mapError { cause ->
            AppNameAcquisitionException(
                packageName = packageName,
                cause = cause,
            )
        }

    class AppNameAcquisitionException(
        val packageName: String,
        override val cause: Throwable,
    ) : UiErrorException(
        error = Res(
            R.string.notifications_could_not_get_app_name,
            packageName,
        )
    )

    companion object {
        private const val TAG = "NotificationsRepo"
    }
}
