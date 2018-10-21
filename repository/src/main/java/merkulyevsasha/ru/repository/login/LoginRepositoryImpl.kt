package merkulyevsasha.ru.repository.login

import merkulyevsasha.ru.data.db.DbSource
import merkulyevsasha.ru.domain.DomainException
import merkulyevsasha.ru.domain.DomainResult
import merkulyevsasha.ru.domain.login.LoginRepository
import merkulyevsasha.ru.domain.login.models.LoginModel
import merkulyevsasha.ru.net.NetDataSource
import merkulyevsasha.ru.prefs.Preferences
import java.lang.Thread.sleep

class LoginRepositoryImpl(
    private val dbSource: DbSource,
    private val netDataSource: NetDataSource,
    private val preferences: Preferences
) : LoginRepository {

    override fun saveToken(token: String) {
        sleep(100)
    }

    override fun login(login: String, password: String): DomainResult<LoginModel, DomainException> {
        sleep(500)
        return DomainResult.Left(LoginModel(login, password))
    }
}