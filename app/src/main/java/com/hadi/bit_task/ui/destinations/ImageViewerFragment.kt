package com.hadi.bit_task.ui.destinations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.hadi.bit_task.databinding.ImageViewerFragmentBinding
import com.squareup.picasso.Picasso

class ImageViewerFragment : Fragment() {
    private lateinit var imageViewerFragmentBinding: ImageViewerFragmentBinding

    private val args: ImageViewerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        imageViewerFragmentBinding = ImageViewerFragmentBinding.inflate(inflater, container, false)

        Picasso.get().load(args.imageUrl).into(imageViewerFragmentBinding.photoView)

        return imageViewerFragmentBinding.root
    }
}