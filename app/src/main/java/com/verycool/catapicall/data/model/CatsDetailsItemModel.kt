package com.verycool.catapicall.data.model


import com.google.gson.annotations.SerializedName

data class CatsDetailsItemModel(
    @SerializedName("breeds")
    val breeds: List<BreedModel?>? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("url")
    val url: String? = null,

)