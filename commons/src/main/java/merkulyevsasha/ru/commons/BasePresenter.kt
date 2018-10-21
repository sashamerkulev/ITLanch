package merkulyevsasha.ru.commons

abstract class BasePresenter<T> {

    protected var view: T? = null

    fun onBindView(view: T) {
        this.view = view
    }

    fun onUnbindView() {
        view = null
    }

    fun onDestroy() {
    }
}