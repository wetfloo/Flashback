package io.wetfloo.flashback.data.db.feature.notifications

import de.yanneckreiss.kconmapper.generated.toSenderAppDomain
import io.wetfloo.flashback.data.db.feature.notifications.model.NotificationLocal
import io.wetfloo.flashback.data.db.feature.notifications.model.NotificationWithSenderAppRelation
import io.wetfloo.flashback.domain.feature.notification.NotificationDomain

fun NotificationWithSenderAppRelation.toNotificationDomain() = NotificationDomain(
    content = notification.content,
    senderApp = senderApp.toSenderAppDomain(),
)

fun NotificationDomain.toNotificationLocal() = NotificationLocal(
    content = content,
    dateTime = dateTime,
    senderAppId = senderApp.appPackageName,
)
