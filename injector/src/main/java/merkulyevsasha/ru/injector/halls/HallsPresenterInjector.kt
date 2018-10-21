package merkulyevsasha.ru.injector.halls

import android.content.Context
import merkulyevsasha.ru.halls.HallsPresenter
import merkulyevsasha.ru.router.ScreenRouter

class HallsPresenterInjector(
    private val context: Context,
    private val screenRouter: ScreenRouter
) {

    private val hallsPresenter: HallsPresenter
        get() {
            return HallsPresenter(
                HallsInteractorInjector(
                    context,
                    screenRouter
                ).getInteractor())
        }

    fun getPresenter(): HallsPresenter {
        return hallsPresenter
    }
}