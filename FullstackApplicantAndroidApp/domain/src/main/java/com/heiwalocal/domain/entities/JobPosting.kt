package com.heiwalocal.domain.entities

data class JobPosting(
    val id: String? = null,
    val vacancyId: String? = null,
    val resumeId: String? = null,
    val jobTitle: String? = null,
    val organizationName: String? = null,
    val organizationLogoUrl: String? = null,
    val status: String? = null,
    val datetime: String? = null,
)