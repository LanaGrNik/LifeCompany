package com.lifecompany.presentation.feature.companydetails

import com.lifecompany.base.BasePresenter
import com.lifecompany.domain.GetCompaniesInteractor
import com.lifecompany.domain.GetCompanyDetailsInteractor
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class CompanyDetailsPresenter @Inject constructor(
    private val interactor: GetCompanyDetailsInteractor
) : BasePresenter<CompanyDetailsView>() {

    fun loadCompanies(id: Int) {
        subscribe(
            interactor.getCompany(id)
        ) {
            viewState.onLoadedCompany(it)
        }
    }
}