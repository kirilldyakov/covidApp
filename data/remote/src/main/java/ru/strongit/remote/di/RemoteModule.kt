package ru.strongit.remote.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import ru.strongit.remote.CovidDatasource
import ru.strongit.remote.CovidService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRemoteModule(baseUrl: String) = module {

    factory<Interceptor> {
        HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.HEADERS)
    }

    factory {
        OkHttpClient.Builder()
                .addInterceptor(get() as Interceptor) //TODO Проверить приведение as
                .build()
    }

    single {
        GsonConverterFactory.create(
                GsonBuilder()
                        //2020/12/26 12:21:56+00"    //TODO Поверить формат времени
                        .setDateFormat("yyyy/MM/dd HH:mm:sszzz")
                        .create()
        )
    }

    single {
        Retrofit.Builder()
                .client(get())
                .baseUrl(baseUrl)
                .addConverterFactory(get<GsonConverterFactory>())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }

    factory { get<Retrofit>().create(CovidService::class.java) }

    factory { CovidDatasource(get()) }
}