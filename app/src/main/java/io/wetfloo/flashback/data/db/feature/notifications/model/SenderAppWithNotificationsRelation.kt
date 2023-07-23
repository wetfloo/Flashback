package io.wetfloo.flashback.data.db.feature.notifications.model

import androidx.room.Embedded
import androidx.room.Relation

data class SenderAppWithNotificationsRelation(
    @Embedded
    val senderApp: SenderAppLocal,

    @Relation(
        parentColumn = "senderAppId",
        entityColumn = "notificationId",
    )
    val notification: List<NotificationLocal>,
)
