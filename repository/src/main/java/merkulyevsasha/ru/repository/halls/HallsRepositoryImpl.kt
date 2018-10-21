package merkulyevsasha.ru.repository.halls

import merkulyevsasha.ru.data.db.DbSource
import merkulyevsasha.ru.domain.halls.HallsRepository
import merkulyevsasha.ru.net.NetDataSource
import merkulyevsasha.ru.prefs.Preferences

class HallsRepositoryImpl(
    private val dbSource: DbSource,
    private val netDataSource: NetDataSource,
    private val preferences: Preferences
) : HallsRepository
