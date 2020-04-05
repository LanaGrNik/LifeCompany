package com.lifecompany.domain.repository

import com.lifecompany.domain.model.Company
import com.lifecompany.domain.model.CompanyDetails
import io.reactivex.Single

interface CompanyRepository {

    fun getCompanies(): Single<List<Company>>

    fun getCompanyById(id: Int): Single<CompanyDetails>
}