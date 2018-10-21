package merkulyevsasha.ru.itlanch

import merkulyevsasha.ru.commons.BasePresenter
import merkulyevsasha.ru.domain.main.MainInteractor

class MainPresenter(private val mainInteractor: MainInteractor) : BasePresenter<MainView>() {
    fun onCreate() {
        mainInteractor.showLoginScreen()
    }
}
