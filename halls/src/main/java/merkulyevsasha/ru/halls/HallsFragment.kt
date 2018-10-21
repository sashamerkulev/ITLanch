package merkulyevsasha.ru.halls

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_halls.toolbar
import merkulyevsasha.ru.commons.ToolbarCombinator

class HallsFragment : Fragment(), HallsView {

    private var presenter: HallsPresenter? = null

    private lateinit var root: View
    private lateinit var combinator: ToolbarCombinator

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ToolbarCombinator) {
            combinator = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_halls, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        toolbar.title = "halls"
        combinator.connectToolbar(toolbar)
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

    companion object {

        @JvmStatic
        fun getInstance(hallsPresenter: HallsPresenter): Fragment {
            val fragment = HallsFragment()
            fragment.presenter = hallsPresenter
            return fragment
        }
    }
}