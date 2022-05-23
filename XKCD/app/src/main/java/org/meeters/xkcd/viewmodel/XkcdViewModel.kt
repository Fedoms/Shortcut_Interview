package org.meeters.xkcd.viewmodel

import androidx.lifecycle.ViewModel
import org.meeters.xkcd.repository.MainRepository
import org.meeters.xkcd.repository.MainRepositoryImpl

class XkcdViewModel (val repository: MainRepository) : ViewModel() {

    fun callCurrentComic(){
        repository.getCurrentComic()
    }

    fun callComicByPage (page: Int){
        repository.getComic(page)
    }


}