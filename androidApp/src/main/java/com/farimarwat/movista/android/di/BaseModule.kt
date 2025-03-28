package com.farimarwat.movista.android.di

import com.farimarwat.movista.android.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModules = module {
    viewModelOf(::MainActivityViewModel)
}