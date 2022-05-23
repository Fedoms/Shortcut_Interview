package org.meeters.xkcd.repository

import org.meeters.xkcd.model.XKcdComic
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApi {

    //integration call for single page
    @GET("https://xkcd.com/{id}/info.0.json")
    fun getPage(@Path("id")id:Int) : XKcdComic

    //integration call for current page

    @GET("https://xkcd.com/info.0.json")
    fun getCurrentPage(): XKcdComic

}