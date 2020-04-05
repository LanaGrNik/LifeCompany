package com.lifecompany.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lifecompany.LifeCompanyApp
import com.lifecompany.base.bind.LayoutBinder
import moxy.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    protected fun appComponent() = (requireActivity().application as LifeCompanyApp).appComponent()

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutBinder.bind(inflater, this)
    }

    /**
     * add DI
     */
    open fun inject() {}

    override fun showProgress() {
        (activity as BaseActivity).showProgress()
    }

    override fun hideProgress() {
        (activity as BaseActivity).hideProgress()
    }

    override fun onError(messageId: Int) {
        onError(getString(messageId))
    }

    override fun onError(message: String) {
        (activity as BaseActivity).onError(message)
    }

    override fun showMessage(message: String) {
        (activity as BaseActivity).showMessage(message)
    }
}
