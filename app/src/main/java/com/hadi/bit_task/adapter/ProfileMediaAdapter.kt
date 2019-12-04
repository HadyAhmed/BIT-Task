package com.hadi.bit_task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hadi.bit_task.databinding.ImageItemBinding
import com.hadi.bit_task.model.Data

class ProfileMediaAdapter(private val onImageClickListener: OnImageClickListener) :
    RecyclerView.Adapter<ProfileMediaAdapter.ImageAdapterViewHolder>() {
    private var data: List<Data>? = null

    fun updateData(data: List<Data>) {
        this.data = data
        notifyDataSetChanged()
    }

    interface OnImageClickListener {
        fun sendImageUrl(imageUrl: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapterViewHolder =
        ImageAdapterViewHolder(
            onImageClickListener,
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ImageAdapterViewHolder, position: Int) {
        holder.bindMedia(data!![position])
    }

    class ImageAdapterViewHolder(
        private val onImageClickListener: OnImageClickListener,
        private val imageItemBinding: ImageItemBinding
    ) :
        RecyclerView.ViewHolder(imageItemBinding.root) {
        fun bindMedia(data: Data) {
            this.imageItemBinding.mediaResponse = data
            this.imageItemBinding.onImageClickListener = onImageClickListener
        }
    }

}