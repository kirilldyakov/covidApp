package ru.strongit.covidapp.di

import ru.strongit.local.di.localModule
import ru.strongit.remote.di.createRemoteModule
import ru.strongit.repository.di.repositoryModule

val appComponent = listOf(
    repositoryModule,
    createRemoteModule("https://covid-api.mmediagroup.fr/v1/"),
    featureCovidModule,
    localModule
)