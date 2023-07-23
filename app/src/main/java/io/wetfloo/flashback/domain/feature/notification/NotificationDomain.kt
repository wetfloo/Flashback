package io.wetfloo.flashback.domain.feature.notification

import androidx.compose.runtime.Stable
import java.time.LocalDateTime

@Stable
data class NotificationDomain(
    val content: String,
    val dateTime: LocalDateTime,
    val id: Int,
)
