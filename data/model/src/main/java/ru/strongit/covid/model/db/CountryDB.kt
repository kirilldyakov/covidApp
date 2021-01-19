package ru.strongit.covid.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
        tableName = "country",
        indices = [Index(value = ["country"], name = "idxName", unique = true)]
)
data class CountryDB(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0L,

        @ColumnInfo(name = "confirmed")
        val confirmed: Long? = null,

        @ColumnInfo(name = "recovered")
        val recovered: Long? = null,

        @ColumnInfo(name = "deaths")
        val deaths: Int? = null,

        @ColumnInfo(name = "country")
        val country: String,

        @ColumnInfo(name = "population")
        val population: Long? = null,

        @ColumnInfo(name = "sq_km_area")
        val sqKmArea: Double? = null,

        @ColumnInfo(name = "life_expectancy")
        val lifeExpectancy: Double? = null,

        @ColumnInfo(name = "elevation_in_meters")
        val elevation: Double? = null,

        @ColumnInfo(name = "continent")
        val continent: String? = null,

        @ColumnInfo(name = "abbreviation")
        val abbreviation: String? = null,

        @ColumnInfo(name = "location")
        val location: String? = null,

        @ColumnInfo(name = "iso")
        val iso: Int? = null,

        @ColumnInfo(name = "capital_city")
        val capitalCity: String? = null,

        @ColumnInfo(name = "lat")
        val latitude: Double? = null,

        @ColumnInfo(name = "long")
        val longitude: Double? = null,

        @ColumnInfo(name = "updated")
        val updated: Date? = null,

        )