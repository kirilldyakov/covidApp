package ru.strongit.local.di

import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.strongit.local.CovidAppDatabase

private const val DATABASE = "DATABASE"

val localModule = module {
    single(qualifier = named(DATABASE)) { CovidAppDatabase.buildDatabase(androidContext()) }
    factory { (get(named(DATABASE)) as CovidAppDatabase).countryDao() }
}