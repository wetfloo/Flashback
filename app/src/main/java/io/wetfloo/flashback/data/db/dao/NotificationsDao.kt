package io.wetfloo.flashback.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.wetfloo.flashback.data.db.model.NotificationLocal
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@Dao
interface NotificationsDao {
    @Query(
        """
        SELECT * 
        FROM NotificationLocal
        """
    )
    fun observeNotifications(): Flow<List<NotificationLocal>>

    @Insert
    suspend fun addNotification(notification: NotificationLocal)

    @Update
    suspend fun updateNotification(notification: NotificationLocal)

    @Query(
        """
        DELETE 
        FROM NotificationLocal
        WHERE dateTime < :dateTime
        """
    )
    suspend fun trimOlderThanDate(dateTime: LocalDateTime)
}
