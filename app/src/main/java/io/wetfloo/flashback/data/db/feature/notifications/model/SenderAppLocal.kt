package io.wetfloo.flashback.data.db.feature.notifications.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.yanneckreiss.kconmapper.annotations.KConMapper
import io.wetfloo.flashback.domain.feature.notification.SenderAppDomain

@Entity
@KConMapper(
    toClasses = [
        SenderAppDomain::class,
    ],
    fromClasses = [
        SenderAppDomain::class,
    ],
)
data class SenderAppLocal(
    val appName: String,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "senderAppId")
    val appPackageName: String,
)
