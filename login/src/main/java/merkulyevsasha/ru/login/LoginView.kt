package merkulyevsasha.ru.login

interface LoginView {
    fun showError(message: String)
    fun showProgress()
    fun hideProgress()
}