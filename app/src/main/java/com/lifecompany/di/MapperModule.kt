package com.lifecompany.di

import com.lifecompany.data.mapper.CompanyDetailsMapper
import com.lifecompany.data.mapper.CompanyMapper
import com.lifecompany.data.mapper.Mapper
import com.lifecompany.data.remote.model.CompanyDetailsDto
import com.lifecompany.data.remote.model.CompanyDto
import com.lifecompany.domain.model.Company
import com.lifecompany.domain.model.CompanyDetails
import dagger.Binds
import dagger.Module

@Module
interface MapperModule {

    @Binds
    fun provideCompanyMapper(mapper: CompanyMapper): Mapper<CompanyDto, Company>

    @Binds
    fun provideCompanyDetailsMapper(mapper: CompanyDetailsMapper): Mapper<CompanyDetailsDto, CompanyDetails>
}