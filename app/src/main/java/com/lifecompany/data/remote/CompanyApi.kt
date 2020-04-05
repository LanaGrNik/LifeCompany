package com.lifecompany.data.remote

import com.lifecompany.data.remote.model.CompanyDetailsDto
import com.lifecompany.data.remote.model.CompanyDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CompanyApi {

    @GET("test.php")
    fun getCompanies(): Single<List<CompanyDto>>

    @GET("test.php")
    fun getCompany(@Query("id") id: Int): Single<List<CompanyDetailsDto>>
}