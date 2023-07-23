package io.wetfloo.flashback.domain.repo

import de.yanneckreiss.kconmapper.generated.toNotificationDomain
import io.wetfloo.flashback.data.db.dao.NotificationsDao
import io.wetfloo.flashback.domain.model.NotificationDomain
import io.wetfloo.flashback.util.mapIter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NotificationsRepository @Inject constructor(
    private val notificationsDao: NotificationsDao,
) {
    fun observeNotifications(): Flow<List<NotificationDomain>> = notificationsDao
        .observeNotifications()
        .mapIter { it.toNotificationDomain() }
}
