package merkulyevsasha.ru.login

import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.android.Main
import kotlinx.coroutines.experimental.launch
import merkulyevsasha.ru.commons.BasePresenter
import merkulyevsasha.ru.domain.login.LoginInteractor
import merkulyevsasha.ru.domain.login.exceptions.BadCredentialsException
import merkulyevsasha.ru.domain.login.exceptions.ConnectionLostException
import merkulyevsasha.ru.domain.login.exceptions.ServerException

class LoginPresenter(private val loginInteractor: LoginInteractor) : BasePresenter<LoginView>() {
    fun onLoginClicked(login: String, password: String) {
        GlobalScope.launch(Dispatchers.Main) {
            view?.showProgress()
            loginInteractor
                .login(login, password)
                .exception {
                    view?.hideProgress()
                    view?.showError(when (it) {
                        is ConnectionLostException -> "no internet, try again"
                        is ServerException -> "try again"
                        is BadCredentialsException -> "wrong login or password"
                        else -> "Oops"
                    })
                }
        }
    }
}
