package com.lifecompany.domain

import com.lifecompany.domain.repository.CompanyRepository
import javax.inject.Inject

class GetCompaniesInteractor @Inject constructor(
    private val repository: CompanyRepository
) {

    fun getCompanies() = repository.getCompanies()
}