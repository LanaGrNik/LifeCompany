package com.lifecompany.base

import androidx.annotation.StringRes
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface BaseView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProgress()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun hideProgress()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun onError(@StringRes messageId: Int)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun onError(message: String)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showMessage(message: String)
}
