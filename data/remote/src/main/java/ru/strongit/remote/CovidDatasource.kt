package ru.strongit.remote


class CovidDatasource(private val covidService: CovidService) {

    fun getCasesAsync(country: String?, ab: String?, continent: String?) =
        covidService.getCases(country, ab, continent)

    fun getHistoryAsync(country: String?, ab: String?, continent: String?, status: String?) =
        covidService.getHistory(country, ab, continent, status)

}