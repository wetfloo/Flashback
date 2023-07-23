package io.wetfloo.flashback.domain.repo

import de.yanneckreiss.kconmapper.generated.toNotificationDomain
import io.wetfloo.flashback.data.db.dao.NotificationsDao
import io.wetfloo.flashback.util.mapIter
import javax.inject.Inject

class NotificationsRepository @Inject constructor(
    private val notificationsDao: NotificationsDao,
) {
    fun observeNotifications() = notificationsDao
        .observeNotifications()
        .mapIter { it.toNotificationDomain() }
}
