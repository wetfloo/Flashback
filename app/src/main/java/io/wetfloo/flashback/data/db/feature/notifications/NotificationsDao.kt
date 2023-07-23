package io.wetfloo.flashback.data.db.feature.notifications

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import io.wetfloo.flashback.data.db.feature.notifications.model.NotificationLocal
import io.wetfloo.flashback.data.db.feature.notifications.model.NotificationWithSenderAppRelation
import io.wetfloo.flashback.data.db.feature.notifications.model.SenderAppLocal
import io.wetfloo.flashback.data.db.feature.notifications.model.SenderAppWithNotificationsRelation
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

    @Upsert
    suspend fun saveNotification(notification: NotificationLocal)

    @Query(
        """
        DELETE 
        FROM NotificationLocal
        WHERE dateTime < :dateTime
        """
    )
    suspend fun trimOlderThanDate(dateTime: LocalDateTime)

    @Query(
        """
        SELECT *
        FROM SenderAppLocal
        """
    )
    fun observeSenderApps(): Flow<List<SenderAppLocal>>

    @Upsert
    suspend fun saveSenderApp(senderApp: SenderAppLocal)

    @Query(
        """
        SELECT *
        FROM SenderAppLocal
        """
    )
    @Transaction
    fun observeSendersWithNotifications(): Flow<List<SenderAppWithNotificationsRelation>>


    @Query(
        """
        SELECT *
        FROM NotificationLocal
        """
    )
    @Transaction
    fun observeNotificationsWithSenders(): Flow<List<NotificationWithSenderAppRelation>>
}
