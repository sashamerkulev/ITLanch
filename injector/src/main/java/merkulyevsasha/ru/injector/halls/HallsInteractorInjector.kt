package merkulyevsasha.ru.injector.halls

import android.content.Context
import merkulyevsasha.ru.domain.order.HallsInteractor
import merkulyevsasha.ru.domain.halls.HallsInteractorImpl
import merkulyevsasha.ru.router.ScreenRouter

class HallsInteractorInjector(
    private val context: Context,
    private val screenRouter: ScreenRouter
) {

    private val roomInteractor: HallsInteractor by lazy {
        HallsInteractorImpl(HallsRepositoryInjector(context).getRepository())
    }

    fun getInteractor(): HallsInteractor {
        return roomInteractor
    }
}