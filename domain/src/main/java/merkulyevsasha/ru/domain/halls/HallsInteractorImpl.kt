package merkulyevsasha.ru.domain.halls

import merkulyevsasha.ru.domain.order.HallsInteractor
import merkulyevsasha.ru.domain.order.HallsRepository

class HallsInteractorImpl(private val hallsRepository: HallsRepository) : HallsInteractor
