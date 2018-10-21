package merkulyevsasha.ru.order

import merkulyevsasha.ru.commons.BasePresenter
import merkulyevsasha.ru.domain.order.HallsInteractor

class OrderPresenter (private val orderInteractor: HallsInteractor): BasePresenter<OrderView>() {
}