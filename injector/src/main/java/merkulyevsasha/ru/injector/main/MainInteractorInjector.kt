package merkulyevsasha.ru.injector.main

import android.content.Context
import merkulyevsasha.ru.domain.main.MainInteractor
import merkulyevsasha.ru.domain.main.MainInteractorImpl
import merkulyevsasha.ru.router.ScreenRouter

class MainInteractorInjector(
    private val context: Context,
    private val router: ScreenRouter
) {
    private val mainInteractor: MainInteractor
        get() {
            return MainInteractorImpl(
                MainRepositoryInjector(context).getRepository(),
                router
            )
        }

    fun getInteractor(): MainInteractor {
        return mainInteractor
    }
}
