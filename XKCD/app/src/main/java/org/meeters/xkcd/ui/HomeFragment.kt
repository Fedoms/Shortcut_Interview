package org.meeters.xkcd.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.meeters.xkcd.R

/**
 * The User will have the possibility to see first the current Comic
 * The user will have the possibility to choose to see more details about the comic
 * The user will have the possibility to choose to see a random Page from the list
 * The user will have the possibility to see th explanation of the page by a module that opens an in app Browwser
 */


class HomeFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}