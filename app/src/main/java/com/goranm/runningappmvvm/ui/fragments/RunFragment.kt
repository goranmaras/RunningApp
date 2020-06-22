package com.goranm.runningappmvvm.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.goranm.runningappmvvm.R
import com.goranm.runningappmvvm.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunFragment : Fragment(R.layout.fragment_run) {

    private val viewModel: MainViewModel by viewModels()

}