package io.wetfloo.flashback.data.db.feature.notifications.model

import androidx.room.Embedded
import androidx.room.Relation

data class NotificationWithSenderAppRelation(
    @Embedded
    val notification: NotificationLocal,

    @Relation(
        parentColumn = "senderAppId",
        entityColumn = "senderAppId",
    )
    val senderApp: SenderAppLocal,
)
