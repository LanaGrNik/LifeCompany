package com.lifecompany.data.mapper

interface Mapper<From, To> {

    fun map(item: From): To

    fun map(items: List<From>): List<To> = items.map(::map)
}