package merkulyevsasha.ru.injector.login

import android.content.Context
import merkulyevsasha.ru.domain.login.LoginRepository
import merkulyevsasha.ru.injector.DataInjector
import merkulyevsasha.ru.repository.login.LoginRepositoryImpl

class LoginRepositoryInjector(private val context: Context) {

    private val loginRepository: LoginRepository
        get() {
            val dataInjector = DataInjector.getInjector(context)
            return LoginRepositoryImpl(
                dataInjector.getDatabase(),
                dataInjector.getNetwork(),
                dataInjector.getPreferences()
            )
        }

    fun getRepository(): LoginRepository {
        return loginRepository
    }
}
