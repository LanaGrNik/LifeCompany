package com.lifecompany.data.mapper

import com.lifecompany.data.remote.model.CompanyDto
import com.lifecompany.domain.model.Company
import javax.inject.Inject

class CompanyMapper @Inject constructor() : Mapper<CompanyDto, Company> {

    override fun map(item: CompanyDto): Company =
        with(item) {
            Company(
                id = id,
                name = name,
                img = img
            )
        }
}