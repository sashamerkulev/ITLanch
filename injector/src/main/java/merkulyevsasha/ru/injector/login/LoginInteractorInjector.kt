package merkulyevsasha.ru.injector.login

import android.content.Context
import merkulyevsasha.ru.domain.login.LoginInteractor
import merkulyevsasha.ru.domain.login.LoginInteractorImpl
import merkulyevsasha.ru.router.ScreenRouter

class LoginInteractorInjector(
    private val context: Context,
    private val router: ScreenRouter
) {

    private val loginInteractor: LoginInteractor
        get() {
            return LoginInteractorImpl(
                LoginRepositoryInjector(context).getRepository(),
                router
            )
        }

    fun getInteractor(): LoginInteractor {
        return loginInteractor
    }
}