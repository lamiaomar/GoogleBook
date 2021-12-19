package com.example.googlebook.network

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.googlebook.data.ItemsItem
import com.example.googlebook.databinding.GridViewItemBinding
import androidx.recyclerview.widget.ListAdapter


class BookGridAdapter : ListAdapter<ItemsItem,
        BookGridAdapter.MoviesPhotoViewHolder>(DiffCallback) {


    class MoviesPhotoViewHolder(
        private var binding:
        GridViewItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(moviesPhoto: ItemsItem) {
            binding.result = moviesPhoto
            binding.executePendingBindings()
        }


    }

    companion object DiffCallback : DiffUtil.ItemCallback<ItemsItem>() {
        override fun areItemsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
            return oldItem.id == newItem.id
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesPhotoViewHolder {
        return MoviesPhotoViewHolder(
            GridViewItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }


    override fun onBindViewHolder(holder: MoviesPhotoViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)

//            holder.button.setOnClickListener {
////            view -> view.findNavController().navigate(R.id.action_moviesFragment_to_detailsFragment)
//                val action =
//                    MoviesFragmentDirections.actionMoviesFragmentToDetailsFragment(position)
//                holder.button.findNavController().navigate(action)
//
//            }


    }

}

