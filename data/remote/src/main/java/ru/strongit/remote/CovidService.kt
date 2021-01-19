package ru.strongit.remote

import kotlinx.coroutines.Deferred
import retrofit2.http.*
import ru.strongit.covid.model.network.ApiResult
import ru.strongit.covid.model.network.CountryNW


interface CovidService {

    @GET("cases")
    fun getCases(
        @Query("country") country: String?,
        @Query("ab") ab: String?,
        @Query("continent") continent: String?
    ): Deferred<ApiResult<CountryNW>>

    @GET("history")
    fun getHistory(
        @Query("country") country: String?,
        @Query("ab") ab: String?,
        @Query("continent") continent: String?,
        @Query("status") status: String? // TODO ->Enum
    ): Deferred<ApiResult<CountryNW>>

}