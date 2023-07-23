package io.wetfloo.flashback.data.db.feature.notifications

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.yanneckreiss.kconmapper.annotations.KConMapper
import io.wetfloo.flashback.domain.feature.notification.NotificationDomain
import java.time.LocalDateTime

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

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)
