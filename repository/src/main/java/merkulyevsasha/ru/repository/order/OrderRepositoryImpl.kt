package merkulyevsasha.ru.repository.order

import merkulyevsasha.ru.data.db.DbSource
import merkulyevsasha.ru.domain.order.HallsRepository
import merkulyevsasha.ru.net.NetDataSource
import merkulyevsasha.ru.prefs.Preferences

class OrderRepositoryImpl(
    private val dbSource: DbSource,
    private val netDataSource: NetDataSource,
    private val preferences: Preferences
) : HallsRepository
