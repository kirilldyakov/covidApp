package ru.strongit.covid.model.entity

import java.util.*

data class Country(
    val id: Long = 0L,
    val confirmed: Long? = null,
    val recovered: Long? = null,
    val deaths: Int? = null,
    val country: String,
    val population: Long? = null,
    val sqKmArea: Double? = null,
    val lifeExpectancy: Double? = null,
    val elevation: Double? = null,
    val continent: String? = null,
    val abbreviation: String? = null,
    val location: String? = null,
    val iso: Int? = null,
    val capitalCity: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val updated: Date? = null,
)
