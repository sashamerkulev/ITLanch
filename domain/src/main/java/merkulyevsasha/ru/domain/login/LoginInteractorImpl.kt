package merkulyevsasha.ru.domain.login

import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.IO
import kotlinx.coroutines.experimental.withContext
import merkulyevsasha.ru.domain.DomainException
import merkulyevsasha.ru.domain.DomainResult
import merkulyevsasha.ru.domain.login.exceptions.SomethingWrongException
import merkulyevsasha.ru.domain.login.models.LoginModel
import merkulyevsasha.ru.router.ScreenRouter

class LoginInteractorImpl(
    private val loginRepository: LoginRepository,
    private val screenRouter: ScreenRouter
) : LoginInteractor {

    override suspend fun login(login: String, password: String): DomainResult<LoginModel, DomainException> {
        var result: DomainResult<LoginModel, DomainException> = DomainResult.Right(SomethingWrongException())
        try {
            withContext(Dispatchers.IO) {
                result = loginRepository.login(login, password)
                result.result {
                    loginRepository.saveToken(it.token)
                    screenRouter.nextScreen(ScreenRouter.Screens.LOGIN)
                }
            }
            return result
        } catch (e: DomainException) {
            return DomainResult.Right(e)
        } catch (e: Exception) {
            return result
        }
    }
}
