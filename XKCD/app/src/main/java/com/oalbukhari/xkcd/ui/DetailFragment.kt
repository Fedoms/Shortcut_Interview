package com.oalbukhari.xkcd.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import com.oalbukhari.xkcd.R
import com.oalbukhari.xkcd.ui.adapter.XkcdAdapter
import com.oalbukhari.xkcd.viewmodel.XkcdViewModel

class DetailFragment : Fragment() {

    /**
     * The Detail will show again the Page with all different information.
     * The User will have the possibility to go back or to check the explanation
     * There will be arrows(back or next) to visualize the oldest or the newest pages with details (No Random Availability)
     */

    private lateinit var adapter: XkcdAdapter

    private val viewModel by sharedViewModel<XkcdViewModel> ()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = XkcdAdapter(requireContext())

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view_info.layoutManager = LinearLayoutManager(context)
        recycler_view_info.adapter = adapter
        viewModel.comicInfo.observe(viewLifecycleOwner, Observer {
            adapter.setInfo(it)
        })

    }

}