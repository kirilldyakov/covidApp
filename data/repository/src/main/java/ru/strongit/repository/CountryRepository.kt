package ru.strongit.repository


import androidx.lifecycle.LiveData
import kotlinx.coroutines.Deferred
import ru.strongit.covid.model.converter.convertFromDB
import ru.strongit.covid.model.converter.convertFromNW
import ru.strongit.covid.model.entity.Country
import ru.strongit.covid.model.network.ApiResult
import ru.strongit.covid.model.network.CountryNW
import ru.strongit.local.dao.CountryDao
import ru.strongit.remote.CovidDatasource
import ru.strongit.repository.utils.NetworkBoundResource
import ru.strongit.repository.utils.Resource


interface CountryRepository {
    suspend fun getCountriesWithCache(forceRefresh: Boolean = false): LiveData<Resource<List<Country>>>

    suspend fun getHistoryWithCache(forceRefresh: Boolean = false): LiveData<Resource<List<Country>>>


    suspend fun saveCountry(country: Country)

    suspend fun insertCountry(country: Country)

    suspend fun selectAll(): List<Country>

    suspend fun delete(id: Long)

    suspend fun delete(country: Country)

    suspend fun getAllCountrys(): List<Country>

    suspend fun getCountry(id: Long): Country
}

class CountryRepositoryImpl(
    private val datasource: CovidDatasource,
    private val dao: CountryDao
) : CountryRepository {

    override suspend fun saveCountry(country: Country) {
        dao.save(country)
    }

    override suspend fun insertCountry(country: Country) {
        dao.create(country)
    }

    override suspend fun selectAll(): List<Country> {
        return dao.getAllCountries().convertFromDB()
    }

    override suspend fun delete(id: Long) {
        dao.deleteCountryById(id)
    }

    override suspend fun delete(country: Country) {
        dao.delete(country)
//        datasource.deleteCountryAsync(country)
    }

    override suspend fun getAllCountrys(): List<Country> {
        return dao.getAllCountries().convertFromDB()
    }

    override suspend fun getCountry(id: Long): Country {
        return dao.getCountry(id)
    }


    override suspend fun getCountriesWithCache(forceRefresh: Boolean): LiveData<Resource<List<Country>>> {
        return object : NetworkBoundResource<List<Country>, ApiResult<CountryNW>>() {

            override fun processResponse(response: ApiResult<CountryNW>): List<Country> =
                response.items.map { it.convertFromNW() }.toList()

            override suspend fun saveCallResults(items: List<Country>) =
                dao.save(items)

            override fun shouldFetch(data: List<Country>?): Boolean =
                data == null || data.isEmpty() || forceRefresh

            override suspend fun loadFromDb(): List<Country> =
                dao.getAllCountries().convertFromDB()

            override fun createCallAsync(): Deferred<ApiResult<CountryNW>> =
                datasource.getCasesAsync(null, null, null)

        }.build().asLiveData()
    }

    override suspend fun getHistoryWithCache(forceRefresh: Boolean): LiveData<Resource<List<Country>>> {
        TODO("Not yet implemented")
    }

}





