package ru.strongit.local.dao

import androidx.room.Dao
import androidx.room.Query
import ru.strongit.covid.model.db.CountryDB

@Dao
abstract class CountryDao : BaseDao<CountryDB>() {

    @Query("SELECT * FROM COUNTRY ORDER BY updated ASC")
    abstract suspend fun getAllCountries(): List<CountryDB>

}