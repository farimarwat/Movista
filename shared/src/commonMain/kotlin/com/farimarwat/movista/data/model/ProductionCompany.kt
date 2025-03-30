package com.farimarwat.movista.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductionCompany(
    val id: Int,
    val logo_path: String? = null,
    val name: String,
    val origin_country: String
)