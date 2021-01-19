package ru.strongit.local.dao

import androidx.room.Dao
import androidx.room.Query
import ru.strongit.covid.model.converter.convertToDB
import ru.strongit.covid.model.db.CountryDB
import ru.strongit.covid.model.entity.Country

@Dao
abstract class CountryDao : BaseDao<CountryDB>() {

    @Query("SELECT * FROM COUNTRY ORDER BY updated ASC")
    abstract suspend fun getAllCountries(): List<CountryDB>

    suspend fun save(country: Country) {
        insert(country.convertToDB())
    }

    suspend fun create(country: Country) {
        insert(country.convertToDB())
    }

    suspend fun save(countries: List<Country>) {
        insert(countries.convertToDB())
    }

    fun deleteCountryById(id: Long) {
        deleteCountryById(id)
    }

    fun delete(country: Country) {
        delete(country)
    }

    //todo
    @Query("SELECT * FROM COUNTRY WHERE id = :id")
    fun getCountry(id: Long): Country {
        return Country( country = "" )
    }


}