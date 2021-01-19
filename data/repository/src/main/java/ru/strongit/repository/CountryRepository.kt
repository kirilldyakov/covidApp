package ru.strongit.repository


import kotlinx.coroutines.Deferred
import ru.strongit.covid.model.network.ApiResult
import ru.strongit.covid.model.network.CountryNW
import ru.strongit.remote.CovidDatasource
import ru.strongit.repository.utils.NetworkBoundResource
import ru.strongit.repository.utils.Resource


interface CountryRepository {
    suspend fun getCountriesWithCache(forceRefresh: Boolean = false): LiveData<Resource<List<CountryNW>>>

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
        return dao.getAllCountrys()
    }

    override suspend fun delete(id: Long) {
        dao.deleteCountryById(id)
    }

    override suspend fun delete(country: Country) {
        dao.delete(country)
        datasource.deleteCountryAsync(country)
    }

    override suspend fun getAllCountrys(): List<Country> {
        return dao.getAllCountrys()
    }

    override suspend fun getCountry(id: Long): Country {
        return dao.getCountry(id)
    }


    override suspend fun getTopCountrysWithCache(forceRefresh: Boolean): LiveData<Resource<List<Country>>> {
        return object : NetworkBoundResource<List<Country>, ApiResult<Country>>() {

            override fun processResponse(response: ApiResult<Country>): List<Country> =
                response.items

            override suspend fun saveCallResults(items: List<Country>) =
                dao.save(items)

            override fun shouldFetch(data: List<Country>?): Boolean =
                data == null || data.isEmpty() || forceRefresh

            override suspend fun loadFromDb(): List<Country> =
                dao.getAllCountrys()

            override fun createCallAsync(): Deferred<ApiResult<Country>> =
                datasource.fetchTopUsersAsync()

        }.build().asLiveData()
    }

    override suspend fun postCountryWithCache(
        forceRefresh: Boolean,
        country: Country
    ): LiveData<Resource<Country>> {

        return object : NetworkBoundResource<Country, ApiResult<Country>>() {
            override fun processResponse(response: ApiResult<Country>): Country {
                return response.items.first()
            }

            override suspend fun saveCallResults(items: Country) = dao.save(items)

            override fun shouldFetch(data: Country?): Boolean {
                return true
            }

            override suspend fun loadFromDb(): Country {
                return Country()
            }

            override fun createCallAsync(): Deferred<ApiResult<Country>> {
                return datasource.postCountryAsync(country)
            }
        }.build().asLiveData()
    }

}