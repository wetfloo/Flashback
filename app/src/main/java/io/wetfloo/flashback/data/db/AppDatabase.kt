package io.wetfloo.flashback.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.wetfloo.flashback.data.db.feature.notifications.NotificationLocal
import io.wetfloo.flashback.data.db.feature.notifications.NotificationsDao

@Database(
    version = 1,
    exportSchema = true,
    entities = [
        NotificationLocal::class,
    ],
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val notificationsDao: NotificationsDao
}
