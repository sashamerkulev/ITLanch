package merkulyevsasha.ru.injector.login

import android.content.Context
import merkulyevsasha.ru.login.LoginPresenter
import merkulyevsasha.ru.router.ScreenRouter

class LoginPresenterInjector(
    private val context: Context,
    private val screenRouter: ScreenRouter
) {

    private val loginPresenter: LoginPresenter
        get() {
            return LoginPresenter(
                LoginInteractorInjector(
                    context,
                    screenRouter
                ).getInteractor())
        }

    fun getPresenter(): LoginPresenter {
        return loginPresenter
    }
}