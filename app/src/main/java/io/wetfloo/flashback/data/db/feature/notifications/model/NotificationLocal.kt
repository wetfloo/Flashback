package io.wetfloo.flashback.data.db.feature.notifications.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class NotificationLocal(
    val content: String,
    val dateTime: LocalDateTime = LocalDateTime.now(),

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "notificationId")
    val uuid: UUID = UUID.randomUUID(),

    val senderAppId: String,
)
