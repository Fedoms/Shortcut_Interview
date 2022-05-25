package com.oalbukhari.xkcd.repository

import com.oalbukhari.xkcd.model.XKcdComic

interface MainRepository {
    suspend fun getCurrentComic(): XKcdComic
    suspend fun getComic(numberComic: Int): XKcdComic
}


class MainRepositoryImpl(val api: ServiceApi) : MainRepository {

    override suspend fun getCurrentComic() = api.getCurrentPage()

    override suspend fun getComic(numberComic: Int) = api.getPage(numberComic)


}

