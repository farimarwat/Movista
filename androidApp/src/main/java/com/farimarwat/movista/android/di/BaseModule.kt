package com.farimarwat.movista.android.di

import com.farimarwat.movista.android.presentation.viewmodel.DetailsScreenViewModel
import com.farimarwat.movista.android.presentation.viewmodel.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModules = module {
    viewModelOf(::HomeScreenViewModel)
    viewModelOf(::DetailsScreenViewModel)
}