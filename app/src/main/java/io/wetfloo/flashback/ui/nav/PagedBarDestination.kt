package io.wetfloo.flashback.ui.nav

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import io.wetfloo.flashback.R
import io.wetfloo.flashback.ui.destinations.DirectionDestination
import io.wetfloo.flashback.ui.destinations.NotificationsScreenDestination
import io.wetfloo.flashback.ui.destinations.SettingsScreenDestination

enum class PagedBarDestination(
    val direction: DirectionDestination,
    val icon: ImageVector,
    @StringRes val label: Int,
) {
    NOTIFICATIONS(
        NotificationsScreenDestination,
        Icons.Default.NotificationsActive,
        R.string.notifications_title,
    ),

    SETTINGS(
        SettingsScreenDestination,
        Icons.Default.Settings,
        R.string.settings_title,
    ),
}
