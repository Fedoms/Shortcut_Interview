package com.oalbukhari.xkcd.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.oalbukhari.xkcd.R

class WebViewBottomSheet(val url: String) : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.modal_bottom_sheet, container, false)

        val webView = view.findViewById<WebView>(R.id.webViewImplemented)
        webView.settings.loadsImagesAutomatically = true;
        webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY;
        webView.loadUrl(url)

        return view
    }


}