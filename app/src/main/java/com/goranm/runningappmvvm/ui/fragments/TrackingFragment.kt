package com.goranm.runningappmvvm.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.goranm.runningappmvvm.R
import com.goranm.runningappmvvm.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackingFragment : Fragment(R.layout.fragment_tracking) {

    private val viewModel: MainViewModel by viewModels()

}