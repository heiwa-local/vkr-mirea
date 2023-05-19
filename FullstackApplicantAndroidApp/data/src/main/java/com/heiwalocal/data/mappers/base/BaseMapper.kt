package com.heiwalocal.data.mappers.base

interface BaseMapper <E, D> {

    fun transform(type: E): D

    fun transformToRepository(type: D): E
}