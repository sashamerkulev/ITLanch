package merkulyevsasha.ru.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import merkulyevsasha.ru.data.db.dao.HallDao
import merkulyevsasha.ru.data.db.dao.HallTableDao
import merkulyevsasha.ru.data.db.entity.HallEntity
import merkulyevsasha.ru.data.db.entity.HallTableEntity


@Database(entities = [HallEntity::class, HallTableEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class LanchDatabase : RoomDatabase() {
    abstract val hallDao: HallDao
    abstract val hallTableDao: HallTableDao
}
