package com.lifecompany.base

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.lifecompany.R
import com.lifecompany.base.bind.LayoutBinder
import moxy.MvpAppCompatActivity
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

abstract class BaseActivity : MvpAppCompatActivity(), BaseView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private lateinit var navigator: SupportAppNavigator

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        LayoutBinder.bind(this)
        navigator = getNavigator()
    }

    abstract fun getNavigator(): SupportAppNavigator

    open fun inject() {}

    override fun showProgress() {
        findViewById<View>(R.id.progressBar)?.apply {
            isVisible = true
        }
    }

    override fun hideProgress() {
        findViewById<View>(R.id.progressBar)?.apply {
            isVisible = false
        }
    }

    override fun onError(messageId: Int) {
        onError(getString(messageId))
    }

    override fun onError(message: String) {
        showMessage(message)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount < 1) {
            finish()
        } else super.onBackPressed()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}
