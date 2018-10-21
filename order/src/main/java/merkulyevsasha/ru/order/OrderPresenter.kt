package merkulyevsasha.ru.order

import merkulyevsasha.ru.commons.BasePresenter
import merkulyevsasha.ru.domain.halls.HallsInteractor

class OrderPresenter(private val orderInteractor: HallsInteractor) : BasePresenter<OrderView>()
