package merkulyevsasha.ru.domain.login

import merkulyevsasha.ru.domain.DomainException
import merkulyevsasha.ru.domain.DomainResult
import merkulyevsasha.ru.domain.login.models.LoginModel

interface LoginRepository {
    fun login(login: String, password: String): DomainResult<LoginModel, DomainException>
    fun saveToken(token: String)
}
