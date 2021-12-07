package com.example.spacexmavericks.feature.latest

import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.example.spacexmavericks.R
import com.example.spacexmavericks.databinding.FragmentLatestBinding
import com.redmadrobot.extensions.viewbinding.viewBinding

class LatestFragment : Fragment(R.layout.fragment_latest), MavericksView {

    private val binding: FragmentLatestBinding by viewBinding()
    private val viewModel: LatestViewModel by fragmentViewModel()

    override fun invalidate() = withState(viewModel) {
        binding.testText.text = it.dummy
    }
}