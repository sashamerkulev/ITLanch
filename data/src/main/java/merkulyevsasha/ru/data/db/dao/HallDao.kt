package merkulyevsasha.ru.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import merkulyevsasha.ru.data.db.entity.HallEntity

@Dao
interface HallDao {
    @Insert
    fun add(hall: HallEntity)
}
