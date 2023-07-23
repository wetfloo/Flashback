package io.wetfloo.flashback.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.wetfloo.flashback.data.db.feature.notifications.NotificationsDao
import io.wetfloo.flashback.data.db.feature.notifications.model.NotificationLocal
import io.wetfloo.flashback.data.db.feature.notifications.model.SenderAppLocal

@Database(
    version = 1,
    exportSchema = true,
    entities = [
        NotificationLocal::class,
        SenderAppLocal::class,
    ],
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val notificationsDao: NotificationsDao
}
