package merkulyevsasha.ru.injector.main

import android.content.Context
import merkulyevsasha.ru.domain.main.MainRepository
import merkulyevsasha.ru.repository.main.MainRepositoryImpl

class MainRepositoryInjector(private val context: Context) {
    private val mainRepository: MainRepository
        get() {
            return MainRepositoryImpl()
        }

    fun getRepository(): MainRepository {
        return mainRepository
    }
}
