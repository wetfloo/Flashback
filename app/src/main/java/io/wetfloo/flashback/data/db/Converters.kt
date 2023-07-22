package io.wetfloo.flashback.data.db

import androidx.room.TypeConverter
import java.time.LocalDateTime

@Suppress("unused")
object Converters {
    // -- java.time.LocalDateTime --
    @TypeConverter
    fun fromLocalDateTime(value: String?) = value?.let(LocalDateTime::parse)

    @TypeConverter
    fun toLocalDateTime(date: LocalDateTime?) = date?.toString()
}
