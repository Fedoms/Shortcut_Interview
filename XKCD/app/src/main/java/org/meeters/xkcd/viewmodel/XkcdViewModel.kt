package org.meeters.xkcd.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.meeters.xkcd.ext.launchIO
import org.meeters.xkcd.model.RecylcerModel
import org.meeters.xkcd.model.VIEW
import org.meeters.xkcd.model.XKcdComic
import org.meeters.xkcd.repository.MainRepository
import kotlin.random.Random

class XkcdViewModel(val repository: MainRepository) : ViewModel() {

    val comic = MutableLiveData<XKcdComic>()
    var maxNumberComic = MutableLiveData<Int>()
    var currentComic = MutableLiveData<Int>()
    var disable = MutableLiveData<DISABLE>()
    val comicInfo = MutableLiveData<List<RecylcerModel>>()
    var comicInfoMutable = mutableListOf<RecylcerModel>()


    init {
        callCurrentComic()
    }

    private fun callCurrentComic() = viewModelScope.launchIO {
        val value = repository.getCurrentComic()
        maxNumberComic.postValue(value.num)
        comic.postValue(value)
        currentComic.postValue(value.num)
        checkDisabled()
        createList()
    }


    fun callComicByPage(page: Int) = viewModelScope.launchIO {
        val value = repository.getComic(page)
        comic.postValue(value)
        currentComic.postValue(value.num)
        checkDisabled()
        createList()
    }


    fun setRandomCall() {
        callComicByPage(Random.nextInt(1, maxNumberComic.value ?: 1))
    }


    fun checkDisabled() {
        if (maxNumberComic.equals(currentComic)) {
            disable.postValue(DISABLE.NEXT)
        } else {
            if (currentComic.equals(1)) {
                disable.postValue(DISABLE.PREVIOUS)
            } else {
                disable.postValue(DISABLE.NORMAL)
            }

        }
    }

    fun next() {
        currentComic.value?.plus(1)?.let { callComicByPage(it) }
    }

    fun previous() {
        currentComic.value?.minus(1)?.let { callComicByPage(it) }

    }

    private fun createList() {
        comicInfoMutable.clear()
        comicInfoMutable.add(
            RecylcerModel(
                "Creation Date: ${comic.value?.day}/${comic.value?.month}/${comic.value?.year}",
                VIEW.TEXT
            )
        )
      //  if (comic.value?.title.isNullOrBlank() && !comic.value?.title.isNullOrEmpty())
        comicInfoMutable.add(RecylcerModel("Title: ${comic.value?.title}", VIEW.TEXT))
       // )
        comicInfoMutable.add(RecylcerModel("Safe Title: ${comic.value?.safe_title}", VIEW.TEXT))
        comicInfoMutable.add(RecylcerModel("Trascript: ${comic.value?.transcript}", VIEW.TEXT))
        comicInfoMutable.add(RecylcerModel("Alt: ${comic.value?.alt}", VIEW.TEXT))
        comicInfoMutable.add(RecylcerModel("${comic.value?.img}", VIEW.IMAGE))
        comicInfoMutable.add(RecylcerModel("https://www.explainxkcd.com/wiki/index.php/+ ${comic.value?.num}", VIEW.WEBSITE))
        comicInfo.postValue(comicInfoMutable)

    }


    enum class DISABLE {
        PREVIOUS,
        NEXT,
        NORMAL
    }


}