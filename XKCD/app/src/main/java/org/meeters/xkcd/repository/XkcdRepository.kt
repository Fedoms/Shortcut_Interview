package org.meeters.xkcd.repository

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.meeters.xkcd.viewmodel.XkcdViewModel
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


val repositoryModule = module {
    single {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    viewModel {
        XkcdViewModel()
    }
    factory{
        //creation Repository everytime activity is deleted
    }

}