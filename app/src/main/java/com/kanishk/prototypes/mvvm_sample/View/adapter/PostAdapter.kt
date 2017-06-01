package com.kanishk.prototypes.mvvm_sample.View.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kanishk.prototypes.mvvm_sample.Model.Post
import com.kanishk.prototypes.mvvm_sample.R
import com.kanishk.prototypes.mvvm_sample.ViewModel.PostViewModel
import com.kanishk.prototypes.mvvm_sample.databinding.ItemPostRowBinding
import java.util.ArrayList

/**
 * Created by kanishk on 31/05/17.
 */

class PostAdapter(private val context: Context, list: ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.PostAdapterBindingHolder>() {

    private var list = ArrayList<Post>()

    init {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapterBindingHolder {
        val postBinding = DataBindingUtil.inflate<ItemPostRowBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_post_row,
                parent,
                false)
        return PostAdapterBindingHolder(postBinding)
    }

    override fun onBindViewHolder(holder: PostAdapterBindingHolder, position: Int) {
        val binding = holder.binding
        binding.viewModel = PostViewModel(context, list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addNewPost(post: Post) {
        list.add(post)
        notifyDataSetChanged()
    }

    inner class PostAdapterBindingHolder(var binding: ItemPostRowBinding) : RecyclerView.ViewHolder(binding.content)
}
