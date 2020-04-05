package com.lifecompany.presentation.feature.companies

import com.lifecompany.base.BasePresenter
import com.lifecompany.domain.GetCompaniesInteractor
import com.lifecompany.presentation.feature.Screens
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class CompanyPresenter @Inject constructor(
    private val interactor: GetCompaniesInteractor,
    private val router: Router
) : BasePresenter<CompanyView>() {

    fun loadCompanies() {
        subscribe(
            interactor.getCompanies()
        ) {
            viewState.onLoadedCompanies(it)
        }
    }

    fun openCompanyDetailsScreen(id: Int) {
        router.navigateTo(Screens.CompanyDetailsScreen(id))
    }
}