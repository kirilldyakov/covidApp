package ru.strongit.repository.di

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.strongit.repository.AppDispatchers
import ru.strongit.repository.CountryRepository
import ru.strongit.repository.CountryRepositoryImpl
import ru.strongit.repository.usecase.CountryUseCase

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { CountryUseCase(get()) }
    factory { CountryRepositoryImpl(get(), get()) } bind CountryRepository::class

}