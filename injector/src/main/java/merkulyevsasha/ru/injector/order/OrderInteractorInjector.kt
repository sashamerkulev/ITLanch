package merkulyevsasha.ru.injector.order

import android.content.Context
import merkulyevsasha.ru.domain.order.HallsInteractor
import merkulyevsasha.ru.domain.order.OrderInteractorImpl

class OrderInteractorInjector(private val context: Context) {

    private val orderInteractor: HallsInteractor by lazy {
        OrderInteractorImpl(OrderRepositoryInjector(context).getRepository())
    }

    fun getInteractor(): HallsInteractor {
        return orderInteractor
    }
}
