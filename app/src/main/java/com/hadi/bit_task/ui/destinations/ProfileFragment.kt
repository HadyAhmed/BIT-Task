package com.hadi.bit_task.ui.destinations

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hadi.bit_task.adapter.ProfileMediaAdapter
import com.hadi.bit_task.databinding.ProfileFragmentBinding
import com.hadi.bit_task.model.MediaDataResponse
import com.hadi.bit_task.model.UserInfoResponse
import com.hadi.bit_task.utils.BitApplicationUtils
import timber.log.Timber

class ProfileFragment : Fragment(), ProfileMediaAdapter.OnImageClickListener {

    private lateinit var viewModel: ProfileViewModel
    private lateinit var profileBinding: ProfileFragmentBinding
    private lateinit var mediaAdapter: ProfileMediaAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mediaAdapter = ProfileMediaAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileBinding = ProfileFragmentBinding.inflate(inflater, container, false)

        val layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
        profileBinding.mediaRv.layoutManager = layoutManager

        BitApplicationUtils.setUpRecyclerViewLayoutManager(
            context,
            profileBinding.mediaRv,
            layoutManager
        )

        profileBinding.mediaRv.adapter = mediaAdapter

        return profileBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()

        viewModel.profileData.observe(this, Observer {
            when {
                it?.resultData != null -> {
                    Timber.i((it.resultData as UserInfoResponse).toString())
                    profileBinding.profileResponse = it.resultData as UserInfoResponse
                }
                it?.responseCode != null -> {
                    showToastMessage("Error code:${it.responseCode}")
                }
                else -> {
                    showToastMessage("Make sure you have stable connection")
                    Timber.e(it.throwable)
                }
            }
        })

        viewModel.profileMedia.observe(this, Observer {
            when {
                it?.resultData != null -> {
                    mediaAdapter.updateData((it.resultData as MediaDataResponse).data)
                }
                it?.responseCode != null -> {
                    showToastMessage("Error code:${it.responseCode}")
                }
                else -> {
                    showToastMessage("Make sure you have stable connection")
                    Timber.e(it.throwable)
                }
            }
        })
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(
            context!!,
            message,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun sendImageUrl(imageUrl: String) {
        findNavController().navigate(
            ProfileFragmentDirections.actionProfileFragmentToImageViewerFragment(
                imageUrl
            )
        )
    }
}
