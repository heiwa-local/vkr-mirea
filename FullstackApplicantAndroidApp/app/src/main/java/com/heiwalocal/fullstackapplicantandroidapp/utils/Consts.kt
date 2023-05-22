package com.heiwalocal.fullstackapplicantandroidapp.utils

val REGIONS = mapOf(
    1 to "Москва",
    2 to "Санкт-Петербург",
    3 to "Казань",
    4 to "Нижний Новгород",
    5 to "Калининград",
    6 to "Владивосток",
)

val TYPES = mapOf(
    1 to "UX/UI Design",
    2 to "Frontend",
    3 to "Backend",
    4 to "DevOps",
    5 to "QA",
)

val EMPLOYMENT = mapOf(
    1 to "Полная занятость",
    2 to "Частичная занятость",
    3 to "Контрактная работа",
    4 to "Стажировка",
)

fun <K, V> getKey(hashMap: Map<K, V>, target: V): String? {
    return try {
        hashMap.filter { target == it.value }.keys.first().toString()
    } catch (e: Exception) {
        null
    }
}