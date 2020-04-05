package com.lifecompany.data.mapper

import com.lifecompany.data.remote.model.CompanyDetailsDto
import com.lifecompany.domain.model.CompanyDetails
import javax.inject.Inject

class CompanyDetailsMapper @Inject constructor(): Mapper<CompanyDetailsDto, CompanyDetails> {

    override fun map(item: CompanyDetailsDto): CompanyDetails =
        with(item) {
            CompanyDetails(
                id = id,
                name = name,
                img = img,
                description = description,
                lat = lat,
                lon = lon,
                www = www,
                phone = phone
            )
        }
}