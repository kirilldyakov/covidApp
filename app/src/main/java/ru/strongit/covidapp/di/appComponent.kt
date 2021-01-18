package ru.strongit.covidapp.di

import ru.strongit.local.di.localModule

val appComponent = listOf(
//        repositoryModule,
//        createRemoteModule("http://192.168.1.40:8087/api/"),
//        createRemoteModule("http://192.168.1.56:8080/api/"),
//        featureModule,
        localModule
)