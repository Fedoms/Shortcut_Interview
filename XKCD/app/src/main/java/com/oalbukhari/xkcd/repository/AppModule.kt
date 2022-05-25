package com.oalbukhari.xkcd.repository

import android.content.Context
import com.bumptech.glide.Glide
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import com.oalbukhari.xkcd.viewmodel.XkcdViewModel
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val logging = HttpLoggingInterceptor()

val appModule = module {
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(logging)
    single {
        Retrofit.Builder()
            .baseUrl("https://xkcd.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(ServiceApi::class.java)
    }
    single <MainRepository>{
        MainRepositoryImpl(get () )
    }
    single{
        XkcdViewModel(get())
    }
    single {
        glide(androidContext())
    }

}

private fun glide(context: Context) = Glide.with(context)

