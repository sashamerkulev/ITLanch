package merkulyevsasha.ru.domain.order

import merkulyevsasha.ru.domain.halls.HallsInteractor
import merkulyevsasha.ru.domain.halls.HallsRepository

class OrderInteractorImpl(private val orderRepository: HallsRepository) : HallsInteractor
