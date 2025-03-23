package com.verycool.catapicall.data.model


import com.google.gson.annotations.SerializedName

data class BreedModel(
    @SerializedName("adaptability")
    val adaptability: Int? = null,
    @SerializedName("affection_level")
    val affectionLevel: Int? = null,
    @SerializedName("alt_names")
    val altNames: String? = null,
    @SerializedName("cfa_url")
    val cfaUrl: String? = null,
    @SerializedName("child_friendly")
    val childFriendly: Int? = null,
    @SerializedName("country_code")
    val countryCode: String? = null,
    @SerializedName("country_codes")
    val countryCodes: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("dog_friendly")
    val dogFriendly: Int? = null,
    @SerializedName("energy_level")
    val energyLevel: Int? = null,
    @SerializedName("experimental")
    val experimental: Int? = null,
    @SerializedName("grooming")
    val grooming: Int? = null,
    @SerializedName("hairless")
    val hairless: Int? = null,
    @SerializedName("health_issues")
    val healthIssues: Int? = null,
    @SerializedName("hypoallergenic")
    val hypoallergenic: Int? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("indoor")
    val indoor: Int? = null,
    @SerializedName("intelligence")
    val intelligence: Int? = null,
    @SerializedName("lap")
    val lap: Int? = null,
    @SerializedName("life_span")
    val lifeSpan: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("natural")
    val natural: Int? = null,
    @SerializedName("origin")
    val origin: String? = null,
    @SerializedName("rare")
    val rare: Int? = null,
    @SerializedName("reference_image_id")
    val referenceImageId: String? = null,
    @SerializedName("rex")
    val rex: Int? = null,
    @SerializedName("shedding_level")
    val sheddingLevel: Int? = null,
    @SerializedName("short_legs")
    val shortLegs: Int? = null,
    @SerializedName("social_needs")
    val socialNeeds: Int? = null,
    @SerializedName("stranger_friendly")
    val strangerFriendly: Int? = null,
    @SerializedName("suppressed_tail")
    val suppressedTail: Int? = null,
    @SerializedName("temperament")
    val temperament: String? = null,
    @SerializedName("vcahospitals_url")
    val vcahospitalsUrl: String? = null,
    @SerializedName("vetstreet_url")
    val vetstreetUrl: String? = null,
    @SerializedName("vocalisation")
    val vocalisation: Int? = null,
    @SerializedName("weight")
    val weight: WeightModel? = WeightModel(),
    @SerializedName("wikipedia_url")
    val wikipediaUrl: String? = null
)