package io.wetfloo.flashback.data.system

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import androidx.core.app.NotificationCompat
import dagger.hilt.android.AndroidEntryPoint
import io.wetfloo.flashback.domain.feature.notification.NotificationsRepository
import io.wetfloo.flashback.util.DispatchersProvider
import io.wetfloo.flashback.util.supervisor
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class NotificationService : NotificationListenerService() {
    @Inject
    lateinit var dispatchers: DispatchersProvider
    private val coroutineScope by lazy {
        dispatchers.supervisor()
    }

    @Inject
    lateinit var notificationsRepository: NotificationsRepository

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)
        val notification = sbn.notification
        if (notification.flags and NotificationCompat.FLAG_GROUP_SUMMARY != 0) {
            // Ignore the groups to avoid notification duplicates.
            // See:
            // https://stackoverflow.com/questions/45890487/android-onnotificationposted-is-called-twice-for-gmail-and-whatsapp
            return
        }

        val appPackageName = if (VERSION.SDK_INT >= VERSION_CODES.Q) {
            sbn.opPkg
        } else {
            sbn.packageName
        }

        val content = sbn.notification.extras.getString(NotificationCompat.EXTRA_TEXT)
        if (content != null) {
            coroutineScope.launch {
                notificationsRepository.saveNotification(
                    content = content,
                    senderAppPackageName = appPackageName,
                )
            }
        }
    }
}
