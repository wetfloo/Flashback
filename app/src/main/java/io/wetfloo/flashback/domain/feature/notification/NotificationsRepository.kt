package io.wetfloo.flashback.domain.feature.notification

import de.yanneckreiss.kconmapper.generated.toNotificationDomain
import de.yanneckreiss.kconmapper.generated.toSenderAppDomain
import io.wetfloo.flashback.data.db.feature.notifications.NotificationsDao
import io.wetfloo.flashback.util.mapIter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotificationsRepository @Inject constructor(
    private val notificationsDao: NotificationsDao,
) {
    fun observeNotifications(): Flow<List<NotificationDomain>> {
        return notificationsDao
            .observeNotificationsWithSenders()
            .mapIter { (notification, sender) ->
                notification.toNotificationDomain(sender.toSenderAppDomain())
            }
    }

    suspend fun saveNotification(notification: NotificationDomain) {

    }
}
