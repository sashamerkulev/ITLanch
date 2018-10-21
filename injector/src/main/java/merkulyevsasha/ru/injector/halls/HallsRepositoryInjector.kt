package merkulyevsasha.ru.injector.halls

import android.content.Context
import merkulyevsasha.ru.domain.halls.HallsRepository
import merkulyevsasha.ru.injector.DataInjector
import merkulyevsasha.ru.repository.order.OrderRepositoryImpl

class HallsRepositoryInjector(private val context: Context) {

    private val roomRepository: HallsRepository by lazy {
        val dataInjector = DataInjector.getInjector(context)
        OrderRepositoryImpl(
            dataInjector.getDatabase(),
            dataInjector.getNetwork(),
            dataInjector.getPreferences()
        )
    }

    fun getRepository(): HallsRepository {
        return roomRepository
    }
}
