package ru.strongit.covidapp.di

import ru.strongit.local.di.localModule
import ru.strongit.remote.di.createRemoteModule

val appComponent = listOf(
//        repositoryModule,
    createRemoteModule("https://covid-api.mmediagroup.fr/v1/"),
//        featureModule,
    localModule
)