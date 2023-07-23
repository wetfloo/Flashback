package io.wetfloo.flashback.data.db.feature.notifications.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.yanneckreiss.kconmapper.annotations.KConMapper
import io.wetfloo.flashback.domain.feature.notification.NotificationDomain
import java.time.LocalDateTime
import java.util.UUID

@Entity
@KConMapper(
    fromClasses = [
        NotificationDomain::class,
    ],
    toClasses = [
        NotificationDomain::class,
    ],
)
data class NotificationLocal(
    val content: String,
    val dateTime: LocalDateTime,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "notificationId")
    val uuid: UUID = UUID.randomUUID(),

    val senderAppId: String,
)
