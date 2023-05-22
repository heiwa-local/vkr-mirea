package com.heiwalocal.data.repositories

import com.heiwalocal.data.mappers.VacancyMapper
import com.heiwalocal.data.mappers.VacancyInfoMapper
import com.heiwalocal.data.services.remote.fullstackapi.FullstackApiService
import com.heiwalocal.domain.entities.Vacancies
import com.heiwalocal.domain.entities.Vacancy
import com.heiwalocal.domain.entities.VacancyInfo
import com.heiwalocal.domain.repositories.VacancyRepository

class VacancyRepositoryImpl(
    private val fullstackApiService: FullstackApiService
): VacancyRepository {

    private val vacanciesMapper = VacancyMapper()
    private val vacancyInfoMapper = VacancyInfoMapper()

    override fun getVacanciesByKeywords(
        keywords: String,
        type: String?,
        salary: String?,
        tags: String?
    ): List<Vacancy>? {
        return fullstackApiService.getVacanciesByKeywords(
            keywords = keywords,
            type = type,
            salary = salary,
            employments = tags
        )?.items?.map { vacanciesMapper.transform(it) }
    }

    override fun getVacancyInfoByVacancyId(
        vacancyId: String,
        accessToken: String
    ): VacancyInfo? {
        val response = fullstackApiService.getVacancyInfoByVacancyId(
            vacancyId = vacancyId,
            accessToken= accessToken
        )

        if (response != null) {
            return vacancyInfoMapper.transform(response)
        }
        return null
    }

    override fun getLastAddedVacancies(): List<Vacancy>? {
        return fullstackApiService.getLastAddedVacancies()?.items?.map { vacanciesMapper.transform(it) }
    }

    override fun getRecommendedVacancies(accessToken: String): List<Vacancy>? {
        return fullstackApiService.getRecommendedVacancies(
            accessToken = accessToken
        )?.items?.map { vacanciesMapper.transform(it) }
    }
}