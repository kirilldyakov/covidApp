package ru.strongit.covid.model.converter

import ru.strongit.covid.model.db.CountryDB
import ru.strongit.covid.model.entity.Country
import ru.strongit.covid.model.network.CountryNW

fun Country.convertToDB() =
    CountryDB(
        id = 0L,
        confirmed = this.confirmed,
        recovered = this.recovered,
        deaths = this.deaths,
        name = this.name,
        population = this.population,
        sqKmArea = this.sqKmArea,
        lifeExpectancy = this.lifeExpectancy,
        elevation = this.elevation,
        continent = this.continent,
        abbreviation = this.abbreviation,
        location = this.location,
        iso = this.iso,
        capitalCity = this.capitalCity,
        latitude = this.latitude,
        longitude = this.longitude,
        updated = this.updated,
    )

fun List<Country>.convertToDB() =
    this.map { it.convertToDB() }.toList()

fun CountryDB.convertFromDB(): Country =
    Country(
        id = 0L,
        confirmed = this.confirmed,
        recovered = this.recovered,
        deaths = this.deaths,
        name = this.name,
        population = this.population,
        sqKmArea = this.sqKmArea,
        lifeExpectancy = this.lifeExpectancy,
        elevation = this.elevation,
        continent = this.continent,
        abbreviation = this.abbreviation,
        location = this.location,
        iso = this.iso,
        capitalCity = this.capitalCity,
        latitude = this.latitude,
        longitude = this.longitude,
        updated = this.updated,
    )

fun List<CountryDB>.convertFromDB() =
    this.map { it.convertFromDB() }.toList()


fun CountryNW.convertFromNW() =
    Country(
        id = 0L,
        confirmed = this.confirmed,
        recovered = this.recovered,
        deaths = this.deaths,
        name = this.name,
        population = this.population,
        sqKmArea = this.sqKmArea,
        lifeExpectancy = this.lifeExpectancy,
        elevation = this.elevation,
        continent = this.continent,
        abbreviation = this.abbreviation,
        location = this.location,
        iso = this.iso,
        capitalCity = this.capitalCity,
        latitude = this.latitude,
        longitude = this.longitude,
        updated = this.updated,
    )

