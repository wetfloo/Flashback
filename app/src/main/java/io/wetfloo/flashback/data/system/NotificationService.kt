package io.wetfloo.flashback.data.system

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import androidx.core.app.NotificationCompat
import dagger.hilt.android.AndroidEntryPoint
import io.wetfloo.flashback.domain.feature.notification.NotificationsRepository
import io.wetfloo.flashback.util.DispatchersProvider
import io.wetfloo.flashback.util.supervisor
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class NotificationService : NotificationListenerService() {
    @Inject
    lateinit var dispatchers: DispatchersProvider
    private val coroutineScope by lazy {
        dispatchers.supervisor()
    }

    @Inject
    lateinit var notificationsRepository: NotificationsRepository

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)
        val notification = sbn.notification
        if (notification.flags and NotificationCompat.FLAG_GROUP_SUMMARY != 0) {
            // Ignore the groups to avoid notification duplicates.
            // See:
            // https://stackoverflow.com/questions/45890487/android-onnotificationposted-is-called-twice-for-gmail-and-whatsapp
            return
        }

        //        val text = notification.extras.getString("android.text") ?: return
        //        val senderApp =kj
        //        val notificationToSave = NotificationDomain(
        //            content = text,
        //            appPackage = sbn.packageName,
        //        )
        val notificationToSave = TODO()
        coroutineScope.launch {
            notificationsRepository.saveNotification(notificationToSave)
        }
    }
}
