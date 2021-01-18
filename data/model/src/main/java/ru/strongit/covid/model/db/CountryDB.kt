package ru.strongit.covid.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(
        tableName = "country"
        //, indices = [Index(value = ["date_time"], name = "idxDate", unique = true)]
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
        val name: String? = null,

        @ColumnInfo(name = "population")
        val population: Long? = null,

        @ColumnInfo(name = "sq_km_area")
        val sqKmArea: Long? = null,

//"life_expectancy": "78.8",
        @ColumnInfo(name = "life_expectancy")
        val lifeExpectancy: Double? = null,

//"elevation_in_meters": 375,
        @ColumnInfo(name = "elevation_in_meters")
        val elevation: Int? = null,

//"continent": "Europe",
        @ColumnInfo(name = "continent")
        val continent: String? = null,

//"abbreviation": "FR",
        @ColumnInfo(name = "abbreviation")
        val abbreviation: String? = null,

//"location": "Western Europe",
        @ColumnInfo(name = "location")
        val location: String? = null,

//"iso": 250,
        @ColumnInfo(name = "iso")
        val iso: Int? = null,

//"capital_city": "Paris",
        @ColumnInfo(name = "capital_city")
        val capitalCity: Long? = null,

//"lat": "46.2276",
        @ColumnInfo(name = "lat")
        val latitude: Double? = null,

//"long": "2.2137",
        @ColumnInfo(name = "long")
        val longitude: Double? = null,

//"updated": "2020/12/26 12:21:56+00"
        @ColumnInfo(name = "updated")
        val updated: Date? = null,

        )