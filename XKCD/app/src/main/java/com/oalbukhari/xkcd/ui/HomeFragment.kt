package com.oalbukhari.xkcd.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.oalbukhari.xkcd.R
import com.oalbukhari.xkcd.viewmodel.XkcdViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * The User will have the possibility to see first the current Comic
 * The user will have the possibility to choose to see more details about the comic
 * The user will have the possibility to choose to see a random Page from the list
 * The user will have the possibility to see the explanation of the page by a module that opens an in app Browwser
 */


class HomeFragment : Fragment() {

    lateinit var modalBottomSheet: WebViewBottomSheet
    private val viewModel by sharedViewModel<XkcdViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.comic.observe(viewLifecycleOwner, Observer {
            modalBottomSheet =
                WebViewBottomSheet("https://www.explainxkcd.com/wiki/index.php/" + "${it.num}")
            Glide.with(this).load(it?.img).into(imageComic)
            titleComics.text = it.title
        })


        detail.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment())
        }

        random.setOnClickListener {
            viewModel.setRandomCall()
        }
        viewModel.disable.observe(viewLifecycleOwner, Observer {
            Log.d("NEXT","${it}")
            when (it) {
                XkcdViewModel.DISABLE.NEXT -> {
                    next.isEnabled = false
                    next.isClickable = false
                }
                XkcdViewModel.DISABLE.PREVIOUS -> {
                    previous.isEnabled = false
                    previous.isClickable = false

                }
                XkcdViewModel.DISABLE.NORMAL -> {
                    next.isEnabled = true
                    next.isClickable = true
                    previous.isEnabled = true
                    previous.isClickable = true

                }
            }
        })
        next.setOnClickListener {
            viewModel.next()
        }
        previous.setOnClickListener {
            viewModel.previous()
        }

        explain.setOnClickListener {
            modalBottomSheet.show(parentFragmentManager, "BOTTOM SHEET ")
        }


    }


}