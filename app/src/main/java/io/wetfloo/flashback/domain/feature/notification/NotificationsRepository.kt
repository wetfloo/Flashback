package io.wetfloo.flashback.domain.feature.notification

import io.wetfloo.flashback.data.db.feature.notifications.NotificationsDao
import io.wetfloo.flashback.data.db.feature.notifications.toNotificationDomain
import io.wetfloo.flashback.data.db.feature.notifications.toNotificationLocal
import io.wetfloo.flashback.util.mapIter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotificationsRepository @Inject constructor(
    private val notificationsDao: NotificationsDao,
) {
    fun observeNotifications(): Flow<List<NotificationDomain>> {
        return notificationsDao
            .observeNotificationsWithSenders()
            .mapIter { notificationRelation ->
                notificationRelation.toNotificationDomain()
            }
    }

    suspend fun saveNotification(
        content: String,
        senderAppPackageName: String,
    ) {
        // TODO: query apps for the actual package name
        //  (this might be inefficient, since app names don't change often)
        val senderApp = SenderAppDomain(
            appName = senderAppPackageName,
            appPackageName = senderAppPackageName,
        )
        val notificationToSave = NotificationDomain(
            content = content,
            senderApp = senderApp,
        )

        notificationsDao.saveNotification(notificationToSave.toNotificationLocal())
    }
}
