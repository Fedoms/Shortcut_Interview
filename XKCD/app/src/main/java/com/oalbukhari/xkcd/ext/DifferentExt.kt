package com.oalbukhari.xkcd.ext

import android.content.Context
import android.content.Intent
import android.net.Uri
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


fun Context.openUrl (url: String){
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
}

fun CoroutineScope.launchIO(
    block: suspend CoroutineScope.() -> Unit
) = launch(context = Dispatchers.IO, block = block)