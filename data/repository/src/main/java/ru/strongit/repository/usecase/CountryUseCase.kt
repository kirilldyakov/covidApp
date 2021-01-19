package ru.strongit.repository.usecase

import kotlinx.coroutines.runBlocking
import ru.strongit.covid.model.network.CountryNW
import ru.strongit.repository.CountryRepository

class CountryUseCase(
    private val covidRepository: CountryRepository
) {

    fun save(countryNW: CountryNW) {
        runBlocking {
            covidRepository.saveCountry(countryNW)
        }
    }

    fun create(countryNW: CountryNW) {
        runBlocking {
            covidRepository.insertCountry(countryNW)
        }
    }

    fun delete(countryNW: CountryNW) {
        runBlocking {
            covidRepository.delete(countryNW)
        }
    }

    suspend fun get(id: Long): CountryNW {
        return covidRepository.getCountry(id)
    }
}