package io.wetfloo.flashback.data.db

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.util.UUID

@Suppress("unused")
object Converters {
    // -- java.time.LocalDateTime --
    @TypeConverter
    fun fromLocalDateTime(date: LocalDateTime?) = date?.toString()

    @TypeConverter
    fun toLocalDateTime(value: String?) = value?.let(LocalDateTime::parse)

    // -- java.util.UUID --
    @TypeConverter
    fun fromUuid(uuid: UUID?) = uuid?.toString()

    @TypeConverter
    fun toUuid(value: String?) = value?.let(UUID::fromString)
}
