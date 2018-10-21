package merkulyevsasha.ru.itlanch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import merkulyevsasha.ru.commons.ToolbarCombinator
import merkulyevsasha.ru.injector.main.MainInteractorInjector
import merkulyevsasha.ru.itlanch.router.ScreenRouterImpl

class MainActivity : AppCompatActivity(), ToolbarCombinator, MainView {

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO how I will test activity? Probably, it is not necessary because single activity fragment!?
        presenter = MainPresenter(MainInteractorInjector(
            this,
            ScreenRouterImpl.getScreenRouter(this, R.id.frameLayout, this.supportFragmentManager)
        ).getInteractor())

        presenter?.onCreate()
    }

    override fun onStart() {
        super.onStart()
        presenter?.onBindView(this)
    }

    override fun onStop() {
        presenter?.onUnbindView()
        super.onStop()
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        presenter = null
        super.onDestroy()
    }

    override fun connectToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
    }
}
