package com.lifecompany.data.repository

import com.lifecompany.data.mapper.Mapper
import com.lifecompany.data.remote.CompanyApi
import com.lifecompany.data.remote.model.CompanyDetailsDto
import com.lifecompany.data.remote.model.CompanyDto
import com.lifecompany.domain.model.Company
import com.lifecompany.domain.model.CompanyDetails
import com.lifecompany.domain.repository.CompanyRepository
import io.reactivex.Single
import javax.inject.Inject

class CompanyDataRepository @Inject constructor(
    private val api: CompanyApi,
    private val companyMapper: Mapper<CompanyDto, Company>,
    private val companyDetailsMapper: Mapper<CompanyDetailsDto, CompanyDetails>
) : CompanyRepository {

    override fun getCompanies(): Single<List<Company>> = api.getCompanies()
        .map(companyMapper::map)

    /**
    Приходит список. Вопрос к аналатику: почему приходит список, когда мы передаем id конкретной компании?
    Xотя по логике должен приходить обьект.
    Было принято решение брать первый из списка.
     **/
    override fun getCompanyById(id: Int): Single<CompanyDetails> = api.getCompany(id)
        .map { it[0] }
        .map(companyDetailsMapper::map)
}