package merkulyevsasha.ru.injector.order

import android.content.Context
import merkulyevsasha.ru.domain.order.HallsRepository
import merkulyevsasha.ru.injector.DataInjector
import merkulyevsasha.ru.repository.order.OrderRepositoryImpl

class OrderRepositoryInjector(private val context: Context) {

    private val orderRepository: HallsRepository by lazy {
        val dataInjector = DataInjector.getInjector(context)
        OrderRepositoryImpl(
            dataInjector.getDatabase(),
            dataInjector.getNetwork(),
            dataInjector.getPreferences()
        )
    }

    fun getRepository(): HallsRepository {
        return orderRepository
    }
}
