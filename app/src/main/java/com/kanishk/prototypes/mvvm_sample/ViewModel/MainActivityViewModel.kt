package com.kanishk.prototypes.mvvm_sample.ViewModel

import android.content.Context
import android.databinding.BaseObservable
import android.view.View

import com.kanishk.prototypes.mvvm_sample.Data.PostDataManager

/**
 * Created by kanishk on 31/05/17.
 */

class MainActivityViewModel(private val context: Context) : BaseObservable() {

    fun onClickAddPost(): View.OnClickListener {
        return View.OnClickListener { PostDataManager.getNewPosts(context) }
    }
}
