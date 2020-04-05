package com.lifecompany.presentation.feature.companies

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.lifecompany.LifeCompanyApp
import com.lifecompany.R
import com.lifecompany.base.BaseActivity
import com.lifecompany.base.bind.Layout
import com.lifecompany.domain.model.Company
import com.lifecompany.presentation.feature.companies.adapter.CompanyAdapter
import kotlinx.android.synthetic.main.activity_company.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

@Layout(R.layout.activity_company)
class CompanyActivity : BaseActivity(), CompanyView {

    @Inject
    @InjectPresenter
    lateinit var presenter: CompanyPresenter

    @ProvidePresenter
    fun providePresenter(): CompanyPresenter = presenter

    private lateinit var companyAdapter: CompanyAdapter

    override fun inject() {
        (application as LifeCompanyApp).appComponent().inject(this)
    }


    override fun getNavigator() = SupportAppNavigator(this, R.id.fragmentContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupAdapter()
        presenter.loadCompanies()
    }

    private fun setupAdapter() {
        companyAdapter = CompanyAdapter { company ->
            company.id?.let { id ->
                presenter.openCompanyDetailsScreen(id)
            }
        }
        companyRecyclerView.apply {
            adapter = companyAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onLoadedCompanies(companies: List<Company>) {
        companyAdapter.setData(companies)
    }
}