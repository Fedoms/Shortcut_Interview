package org.meeters.xkcd.repository

import android.content.Context
import com.bumptech.glide.Glide
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.meeters.xkcd.viewmodel.XkcdViewModel
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ServiceApi::class.java)
    }
    single <MainRepository>{
        MainRepositoryImpl(get () )
    }
    viewModel{
        XkcdViewModel(get())
    }
    single {
        glide(androidContext())
    }

}

private fun glide(context: Context) = Glide.get(context)