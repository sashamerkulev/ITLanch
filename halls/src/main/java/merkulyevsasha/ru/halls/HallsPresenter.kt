package merkulyevsasha.ru.halls

import merkulyevsasha.ru.commons.BasePresenter
import merkulyevsasha.ru.domain.halls.HallsInteractor

class HallsPresenter(private val roomInteractor: HallsInteractor) : BasePresenter<HallsView>()