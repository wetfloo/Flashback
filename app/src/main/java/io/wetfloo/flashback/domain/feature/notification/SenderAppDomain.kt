package io.wetfloo.flashback.domain.feature.notification

import androidx.compose.runtime.Stable

@Stable
data class SenderAppDomain(
    val appName: String,
    val appPackageName: String,
)
