package com.kanishk.prototypes.mvvm_sample.Data

import android.content.Context

import com.kanishk.prototypes.mvvm_sample.Bus.Event.PostEvent
import com.kanishk.prototypes.mvvm_sample.Bus.EventModel.PostEventModel
import com.kanishk.prototypes.mvvm_sample.Model.Post

import java.util.ArrayList

/**
 * Created by kanishk on 31/05/17.
 */

object PostDataManager {

    fun getPosts(c: Context, pe: PostEvent) {
        val events = pe
        val list = ArrayList<Post>()
        list.add(Post("Post 1", "A new post using MVVM!", "kanishk"))
        list.add(Post("Post 2", "A second post using MVVM!", "kanishk"))
        list.add(Post("Post 3", "A third post using MVVM!", "kanishk"))
        list.add(Post("Post 4", "A fourth post using MVVM!", "kanishk"))
        list.add(Post("Post 5", "A fifth post using MVVM!", "kanishk"))
        val eventModel = PostEventModel(list)
        events.onDataReceived(eventModel)
    }

    fun getNewPosts(c: Context) {
        val events = c as PostEvent
        val list = ArrayList<Post>()
        list.add(Post("Post 1", "A new post using MVVM!", "kanishk"))
        val eventModel = PostEventModel(list)
        events.onDataUpdate(eventModel)
    }
}
