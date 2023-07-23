package io.wetfloo.flashback.domain.feature.notification

import androidx.compose.runtime.Stable
import java.time.LocalDateTime
import java.util.UUID

@Stable
data class NotificationDomain(
    val content: String,
    val senderApp: SenderAppDomain,

    val dateTime: LocalDateTime = LocalDateTime.now(),

    val uuid: UUID = UUID.randomUUID(),
)
