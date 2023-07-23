package io.wetfloo.flashback.ui.feature.notifications.component

import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import io.wetfloo.flashback.domain.feature.notification.NotificationDomain
import io.wetfloo.flashback.ui.theme.AppTheme
import java.time.LocalDateTime
import java.util.UUID

@Composable
fun NotificationItem(
    modifier: Modifier = Modifier,
    notification: NotificationDomain,
) {
    val context = LocalContext.current

    Box(
        modifier = modifier,
    ) {
        Text(
            text = notification.content,
            modifier = Modifier
                .clickable {
                    context.startActivity(
                        Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"),
                    )
                }
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun NotificationItemPreview() {
    AppTheme {
        NotificationDomain(
            content = "Some notification content",
            dateTime = LocalDateTime.now(),
            id = UUID.randomUUID().hashCode(),
        )
    }
}
