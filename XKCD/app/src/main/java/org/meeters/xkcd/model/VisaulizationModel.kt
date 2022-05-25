package org.meeters.xkcd.model

data class RecylcerModel(
    val value: String,
    val view: VIEW
)

enum class VIEW{
    TEXT,
    IMAGE,
    WEBSITE
}

