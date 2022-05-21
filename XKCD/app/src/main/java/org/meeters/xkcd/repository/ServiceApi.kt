package org.meeters.xkcd.repository

import org.meeters.xkcd.model.XKcdComic
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApi {

    //integration call for single page
    @GET("/{id}/form.0.json")
    fun getPage(@Path("id")id:Int) : XKcdComic

    //integration call for current page

    @GET("/form.0.json")
    fun getCurrentPage(): XKcdComic

}