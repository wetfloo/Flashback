package io.wetfloo.flashback.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NotificationLocal(
    val content: String,

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)
