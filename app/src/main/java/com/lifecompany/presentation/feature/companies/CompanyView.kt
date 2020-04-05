package com.lifecompany.presentation.feature.companies

import com.lifecompany.base.BaseView
import com.lifecompany.domain.model.Company
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface CompanyView: BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun onLoadedCompanies(companies: List<Company>)
}