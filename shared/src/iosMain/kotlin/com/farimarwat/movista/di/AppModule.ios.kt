package com.farimarwat.movista.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.movista.MovistaDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module{
    single<SqlDriver>{
        NativeSqliteDriver(
            MovistaDatabase.Schema,"movista.db"
        )
    }
}