package com.heiwalocal.domain.entities

data class Resume (
    val id: String? = null,
    val applicantId: String? = null,
    val jobTitle: String? = null,
    val grade: String? = null,
    val address: String? = null,
    val salary: Double? = null,
    val skills: String? = null,
    val education: String? = null,
    val workExperience: String? = null,
    val datetime: String? = null
)