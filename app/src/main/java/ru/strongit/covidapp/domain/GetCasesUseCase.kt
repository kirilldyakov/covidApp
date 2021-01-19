package ru.strongit.covidapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import ru.strongit.covid.model.entity.Country
import ru.strongit.repository.CountryRepository
import ru.strongit.repository.utils.Resource

class GetCasesUseCase(
    private val repository: CountryRepository
) {
    suspend operator fun invoke(forceRefresh: Boolean = false): LiveData<Resource<List<Country>>> {
        return Transformations.map(repository.getCountriesWithCache(forceRefresh)) {
            it // Place here your specific logic actions
        }
    }
}