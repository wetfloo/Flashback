package io.wetfloo.flashback.data.system

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification

class NotificationService : NotificationListenerService() {
    private var isOkToRead = false

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)

        if (isOkToRead) {
            TODO()
        }
    }
}
