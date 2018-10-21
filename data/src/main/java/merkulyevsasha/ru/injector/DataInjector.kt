package merkulyevsasha.ru.injector

import android.arch.persistence.room.Room
import android.content.Context
import merkulyevsasha.ru.data.BuildConfig
import merkulyevsasha.ru.data.db.DbSource
import merkulyevsasha.ru.data.db.DbSourceImpl
import merkulyevsasha.ru.data.db.LanchDatabase
import merkulyevsasha.ru.net.NetDataSource
import merkulyevsasha.ru.net.NetDataSourceImpl
import merkulyevsasha.ru.prefs.Preferences
import merkulyevsasha.ru.prefs.PreferencesImpl

class DataInjector private constructor(private val context: Context) {

    private val db: DbSource by lazy {
        DbSourceImpl(Room
            .databaseBuilder(context, LanchDatabase::class.java, BuildConfig.DB_NAME)
            .fallbackToDestructiveMigration()
            .build())
    }

    private val net: NetDataSource by lazy {
        NetDataSourceImpl(context)
    }

    private val pref: Preferences by lazy {
        PreferencesImpl(context)
    }

    fun getDatabase(): DbSource {
        return db
    }

    fun getNetwork(): NetDataSource {
        return net
    }

    fun getPreferences(): Preferences {
        return pref
    }

    companion object {
        fun getInjector(context: Context): DataInjector {
            return DataInjector(context)
        }
    }
}
