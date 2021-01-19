package ru.strongit.covidapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.strongit.covidapp.domain.GetCasesUseCase
import ru.strongit.covidapp.ui.global.GlobalViewModel

val featureCovidModule = module {
    viewModel { GlobalViewModel(get(), get(), get()) }

    factory { GetCasesUseCase(get()) }
}