package com.heiwalocal.domain.entities

data class Vacancy(
    val id: String? = null,
    val organizationName: String? = null,
    val organizationLogoUrl: String? = null,
    val jobTitle: String? = null,
    val salary: Double? = null,
    val address: String? = null,
    val employment: String? = null,
    val description: String? = null,
)