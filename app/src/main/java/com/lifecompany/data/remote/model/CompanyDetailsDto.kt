package com.lifecompany.data.remote.model

import com.google.gson.annotations.SerializedName

data class CompanyDetailsDto(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("img")
    val img: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("lat")
    val lat: Double? = null,

    @SerializedName("lon")
    val lon: Double? = null,

    @SerializedName("www")
    val www: String? = null,

    @SerializedName("phone")
    val phone: String? = null
)