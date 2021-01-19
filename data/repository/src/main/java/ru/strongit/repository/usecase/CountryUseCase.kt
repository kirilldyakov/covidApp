package ru.strongit.repository.usecase

import kotlinx.coroutines.runBlocking
import ru.strongit.covid.model.entity.Country
import ru.strongit.covid.model.network.CountryNW
import ru.strongit.repository.CountryRepository

class CountryUseCase(
    private val covidRepository: CountryRepository
) {

    fun save(country: Country) {
        runBlocking {
            covidRepository.saveCountry(country)
        }
    }

    fun create(country: Country) {
        runBlocking {
            covidRepository.insertCountry(country)
        }
    }

    fun delete(country: Country) {
        runBlocking {
            covidRepository.delete(country)
        }
    }

    suspend fun get(id: Long): Country {
        return covidRepository.getCountry(id)
    }
}