package com.heiwalocal.fullstackapplicantandroidapp.utils


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