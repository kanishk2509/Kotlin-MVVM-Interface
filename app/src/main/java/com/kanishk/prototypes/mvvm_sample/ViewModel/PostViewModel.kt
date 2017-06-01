package com.kanishk.prototypes.mvvm_sample.ViewModel

import android.content.Context
import android.databinding.BaseObservable
import android.view.View
import android.widget.Toast

import com.kanishk.prototypes.mvvm_sample.Model.Post

/**
 * Created by kanishk on 31/05/17.
 */

class PostViewModel(private val context: Context, private val post: Post) : BaseObservable() {

    val postTitle: String
        get() = post.title

    val postAuthor: String
        get() = post.postedByUsername

    val postDescription: String
        get() = post.description

    fun onClickPost(): View.OnClickListener {
        return View.OnClickListener { sayHello() }
    }

    private fun sayHello() {
        Toast.makeText(context, "Hello there!", Toast.LENGTH_SHORT).show()
    }
}