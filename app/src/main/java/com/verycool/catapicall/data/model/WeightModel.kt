package com.verycool.catapicall.data.model


import com.google.gson.annotations.SerializedName

data class WeightModel(
    @SerializedName("imperial")
    val imperial: String? = null,
    @SerializedName("metric")
    val metric: String? = null
)