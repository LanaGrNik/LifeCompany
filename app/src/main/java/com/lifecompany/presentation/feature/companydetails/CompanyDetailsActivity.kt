package com.lifecompany.presentation.feature.companydetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import com.bumptech.glide.Glide
import com.lifecompany.BuildConfig
import com.lifecompany.LifeCompanyApp
import com.lifecompany.R
import com.lifecompany.base.BaseActivity
import com.lifecompany.base.bind.Layout
import com.lifecompany.domain.model.CompanyDetails
import com.lifecompany.util.extentions.callPhone
import com.lifecompany.util.extentions.openUrl
import kotlinx.android.synthetic.main.activity_details_company.*
import kotlinx.android.synthetic.main.company_item.view.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

@Layout(R.layout.activity_details_company)
class CompanyDetailsActivity: BaseActivity(), CompanyDetailsView {

    @Inject
    @InjectPresenter
    lateinit var presenter: CompanyDetailsPresenter

    @ProvidePresenter
    fun providePresenter(): CompanyDetailsPresenter = presenter

    override fun inject() {
        (application as LifeCompanyApp).appComponent().inject(this)
    }

    override fun getNavigator() = SupportAppNavigator(this, R.id.fragmentContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getIntExtra(COMPANY_ID,-1)
        companyUrl.setOnClickListener { openUrl(companyUrl.text.toString()) }
        companyPhone.setOnClickListener { callPhone(companyPhone.text.toString()) }
        presenter.loadCompanies(id)
    }

    override fun onLoadedCompany(company: CompanyDetails) {
        Glide.with(this)
            .load("${BuildConfig.API_SERVER}${company.img}")
            .into(companyImg)

        companyName.text = company.name
        companyDescription.text = company.description

        Glide.with(this)
            .load("${YANDEX_MAP_IMAGE_URL}${company.lat},${company.lon}")
            .into(companyLocation)

        companyUrl.text = company.www
        companyPhone.text = company.phone
    }

    companion object {
        private const val COMPANY_ID = "company_id"
        private const val YANDEX_MAP_IMAGE_URL = "https://static-maps.yandex.ru/1.x/?size=450,450&z=8&l=map&pt="

        fun getIntent(context: Context, id: Int) = Intent(context, CompanyDetailsActivity::class.java).apply {
            putExtra(COMPANY_ID, id)
        }
    }

}