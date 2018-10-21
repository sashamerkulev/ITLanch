package merkulyevsasha.ru.router

interface ScreenRouter {

    fun loginScreen()
    fun nextScreen(currentScreen: Screens)
    fun prevScreen(currentScreen: Screens)

    enum class Screens {
        LOGIN,
        HALLS,
        ORDER
    }
}
