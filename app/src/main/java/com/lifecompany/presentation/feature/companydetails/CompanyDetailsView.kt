package com.lifecompany.presentation.feature.companydetails

import com.lifecompany.base.BaseView
import com.lifecompany.domain.model.Company
import com.lifecompany.domain.model.CompanyDetails
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface CompanyDetailsView: BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun onLoadedCompany(company: CompanyDetails)
}