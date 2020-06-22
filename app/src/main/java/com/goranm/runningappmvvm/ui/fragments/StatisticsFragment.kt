package com.goranm.runningappmvvm.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.goranm.runningappmvvm.R
import com.goranm.runningappmvvm.ui.viewmodels.MainViewModel
import com.goranm.runningappmvvm.ui.viewmodels.StatisticsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    private val viewModel: StatisticsViewModel by viewModels()

}