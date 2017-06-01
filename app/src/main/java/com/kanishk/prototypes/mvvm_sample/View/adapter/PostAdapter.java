package com.kanishk.prototypes.mvvm_sample.View.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kanishk.prototypes.mvvm_sample.Model.Post;
import com.kanishk.prototypes.mvvm_sample.R;
import com.kanishk.prototypes.mvvm_sample.ViewModel.PostViewModel;
import com.kanishk.prototypes.mvvm_sample.databinding.ItemPostRowBinding;

import java.util.ArrayList;

/**
 * Created by kanishk on 31/05/17.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostAdapterBindingHolder> {

    private ArrayList<Post> list = new ArrayList<>();
    private Context context;

    public PostAdapter(Context context, ArrayList<Post> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public PostAdapterBindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPostRowBinding postBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_post_row,
                parent,
                false);
        return new PostAdapterBindingHolder(postBinding);
    }

    @Override
    public void onBindViewHolder(PostAdapterBindingHolder holder, int position) {
        ItemPostRowBinding binding = holder.binding;
        binding.setViewModel(new PostViewModel(context, list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addNewPost(Post post) {
        list.add(post);
        notifyDataSetChanged();
    }

    class PostAdapterBindingHolder extends RecyclerView.ViewHolder {

        ItemPostRowBinding binding;

        PostAdapterBindingHolder(ItemPostRowBinding binding) {
            super(binding.content);
            this.binding = binding;
        }
    }
}
