package com.lifecompany.domain

import com.lifecompany.domain.repository.CompanyRepository
import javax.inject.Inject

class GetCompanyDetailsInteractor @Inject constructor(
    private val repository: CompanyRepository
) {

    fun getCompany(id: Int) = repository.getCompanyById(id)
}