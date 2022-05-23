package org.meeters.xkcd.repository

interface  MainRepository{
    fun getCurrentComic()
    fun getComic(numberComic:Int)
}


class  MainRepositoryImpl (val api: ServiceApi) : MainRepository{
    override fun getCurrentComic() {
        api.getCurrentPage()
    }

    override fun getComic(numberComic: Int) {
        api.getPage(numberComic)
    }


}

