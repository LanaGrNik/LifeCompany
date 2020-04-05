package com.lifecompany.di

import com.lifecompany.data.repository.CompanyDataRepository
import com.lifecompany.domain.repository.CompanyRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun provideCompanyRepository(repository: CompanyDataRepository): CompanyRepository
}