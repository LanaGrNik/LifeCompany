package com.lifecompany.data.remote.model

import com.google.gson.annotations.SerializedName

data class CompanyDto(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("img")
    val img: String? = null
)