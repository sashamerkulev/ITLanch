package merkulyevsasha.ru.login

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_login.button
import kotlinx.android.synthetic.main.fragment_login.login
import kotlinx.android.synthetic.main.fragment_login.password
import kotlinx.android.synthetic.main.fragment_login.progressbar
import kotlinx.android.synthetic.main.fragment_login.shadow
import kotlinx.android.synthetic.main.fragment_login.toolbar
import merkulyevsasha.ru.commons.ToolbarCombinator

class LoginFragment : Fragment(), LoginView {

    private var presenter: LoginPresenter? = null

    private lateinit var root: View
    private lateinit var combinator: ToolbarCombinator

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is ToolbarCombinator) {
            combinator = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_login, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        toolbar.title = "login"
        combinator.connectToolbar(toolbar)

        button.setOnClickListener { presenter?.onLoginClicked(login.text.toString(), password.text.toString()) }
    }

    override fun onStart() {
        super.onStart()
        presenter?.onBindView(this)
    }

    override fun onStop() {
        presenter?.onUnbindView()
        super.onStop()
    }

    override fun onDestroyView() {
        presenter?.onDestroy()
        presenter = null
        super.onDestroyView()
    }

    override fun showProgress() {
        button.visibility = View.GONE
        shadow.visibility = View.VISIBLE
        login.isEnabled = false
        password.isEnabled = false
        progressbar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        button.visibility = View.VISIBLE
        shadow.visibility = View.GONE
        login.isEnabled = true
        password.isEnabled = true
        progressbar.visibility = View.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    companion object {

        @JvmStatic
        fun getInstance(loginPresenter: LoginPresenter): Fragment {
            val fragment = LoginFragment()
            fragment.presenter = loginPresenter
            return fragment
        }
    }
}
