package ru.strongit.covid.model.network

import com.google.gson.annotations.SerializedName
import java.util.*

data class CountryNW(
//        val id: Long = 0L,

        @SerializedName("confirmed")
        val confirmed: Long? = null,

        @SerializedName("recovered")
        val recovered: Long? = null,

        @SerializedName("deaths")
        val deaths: Int? = null,

        @SerializedName("country")
        val country: String? = null,

        @SerializedName("population")
        val population: Long? = null,

        @SerializedName("sq_km_area")
        val sqKmArea: Double? = null,

        @SerializedName("life_expectancy")
        val lifeExpectancy: Double? = null,

        @SerializedName("elevation_in_meters")
        val elevation: String? = null,

        @SerializedName("continent")
        val continent: String? = null,

        @SerializedName("abbreviation")
        val abbreviation: String? = null,

        @SerializedName("location")
        val location: String? = null,

        @SerializedName("iso")
        val iso: Int? = null,

        @SerializedName("capital_city")
        val capitalCity: String? = null,

        @SerializedName("lat")
        val latitude: String? = null,

        @SerializedName("long")
        val longitude: String? = null,

        @SerializedName("updated")
        val updated: Date? = null,

        )