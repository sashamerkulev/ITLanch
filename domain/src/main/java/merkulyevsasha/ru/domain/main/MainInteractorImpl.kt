package merkulyevsasha.ru.domain.main

import merkulyevsasha.ru.router.ScreenRouter

class MainInteractorImpl(
    private val mainRepository: MainRepository,
    private val router: ScreenRouter
) : MainInteractor {

    override fun showLoginScreen() {
        router.loginScreen()
    }
}