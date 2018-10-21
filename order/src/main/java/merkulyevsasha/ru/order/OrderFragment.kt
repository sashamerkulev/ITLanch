package merkulyevsasha.ru.order

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_order.*
import merkulyevsasha.ru.commons.ToolbarCombinator

class OrderFragment : Fragment(), OrderView {

    private var presenter: OrderPresenter? = null

    private lateinit var root: View
    private lateinit var combinator: ToolbarCombinator

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ToolbarCombinator) {
            combinator = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_order, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
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
        fun getInstance(orderPresenter: OrderPresenter): Fragment {
            val fragment = OrderFragment()
            fragment.presenter = orderPresenter
            return fragment
        }
    }
}
