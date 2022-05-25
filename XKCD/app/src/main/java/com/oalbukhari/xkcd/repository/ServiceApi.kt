package com.oalbukhari.xkcd.repository

import com.oalbukhari.xkcd.model.XKcdComic
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApi {

    //integration call for single page
    @GET("/{id}/info.0.json")
    suspend fun getPage(@Path("id")id:Int) : XKcdComic

    //integration call for current page

    @GET("/info.0.json")
    suspend fun getCurrentPage(): XKcdComic

}