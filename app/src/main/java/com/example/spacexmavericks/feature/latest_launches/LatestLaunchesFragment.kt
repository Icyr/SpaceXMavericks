package com.example.spacexmavericks.feature.latest_launches

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.example.spacexmavericks.R
import com.example.spacexmavericks.databinding.FragmentLatestLaunchesBinding
import com.example.spacexmavericks.widget.launchView
import com.google.android.material.snackbar.Snackbar
import com.redmadrobot.extensions.viewbinding.viewBinding

class LatestFragment : Fragment(R.layout.fragment_latest_launches), MavericksView {

    private val binding: FragmentLatestLaunchesBinding by viewBinding()
    private val viewModel: LatestLaunchesViewModel by fragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onAsync(
            LatestLaunchesState::launches,
            uniqueOnly(),
            onFail = {
                Snackbar.make(binding.root, "Launches request failed.", Snackbar.LENGTH_INDEFINITE).show()
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.latestRecycler.buildModelsWith(object : EpoxyRecyclerView.ModelBuilderCallback {
            override fun buildModels(controller: EpoxyController) {
                controller.buildModels()
            }
        })
    }

    override fun invalidate() {
        binding.latestRecycler.requestModelBuild()
    }

    private fun EpoxyController.buildModels() = withState(viewModel) { state ->
        state.launches()?.forEach {
            launchView {
                id(it.id)
                title(it.missionName)
                subtitle(it.rocketName)
            }
        }
    }
}