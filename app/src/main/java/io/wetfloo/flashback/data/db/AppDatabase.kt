package io.wetfloo.flashback.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    version = 1,
    exportSchema = true,
    entities = [],
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase()
