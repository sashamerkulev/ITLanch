package merkulyevsasha.ru.itlanch.router

import android.content.Context
import android.support.v4.app.FragmentManager
import merkulyevsasha.ru.injector.login.LoginPresenterInjector
import merkulyevsasha.ru.login.LoginFragment
import merkulyevsasha.ru.halls.HallsFragment
import merkulyevsasha.ru.injector.halls.HallsPresenterInjector
import merkulyevsasha.ru.router.ScreenRouter

class ScreenRouterImpl private constructor(
    private val context: Context,
    private val frameRes: Int,
    private val fragmentManager: FragmentManager
) : ScreenRouter {

    override fun loginScreen() {
        val fragment = LoginFragment.getInstance(LoginPresenterInjector(context, this).getPresenter())
        fragmentManager.beginTransaction()
            .replace(frameRes, fragment, "LOGIN")
            .commitNow()
    }

    override fun nextScreen(currentScreen: ScreenRouter.Screens) {
        if (currentScreen == ScreenRouter.Screens.LOGIN) {
            val fragment = HallsFragment.getInstance(HallsPresenterInjector(context, this).getPresenter())
            fragmentManager.beginTransaction()
                .replace(frameRes, fragment, "HALLS")
                .commit()
        }
    }

    override fun prevScreen(currentScreen: ScreenRouter.Screens) {
    }

    companion object {
        fun getScreenRouter(
            context: Context,
            frameRes: Int,
            fragmentManager: FragmentManager
        ): ScreenRouter {
            return ScreenRouterImpl(context, frameRes, fragmentManager)
        }
    }
}