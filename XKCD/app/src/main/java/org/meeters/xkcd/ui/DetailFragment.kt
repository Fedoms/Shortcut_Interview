package org.meeters.xkcd.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.meeters.xkcd.R

class DetailFragment : Fragment() {

    /**
     * The Detail will show again the Page with all different information.
     * The User will have the possibility to go back or to check the explanation
     * There will be arrows(back or next) to visualize the oldest or the newest pages with details (No Random Availability)
     */


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

}