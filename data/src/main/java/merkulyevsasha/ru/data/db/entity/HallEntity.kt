package merkulyevsasha.ru.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "halls")
data class HallEntity(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)