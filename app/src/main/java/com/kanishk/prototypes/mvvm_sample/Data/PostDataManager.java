package com.kanishk.prototypes.mvvm_sample.Data;

import android.content.Context;

import com.kanishk.prototypes.mvvm_sample.Bus.Event.PostEvent;
import com.kanishk.prototypes.mvvm_sample.Bus.EventModel.PostEventModel;
import com.kanishk.prototypes.mvvm_sample.Model.Post;

import java.util.ArrayList;

/**
 * Created by kanishk on 31/05/17.
 */

public class PostDataManager {

    public static void getPosts(Context c) {
        PostEvent events = (PostEvent) c;
        ArrayList<Post> list = new ArrayList<>();
        list.add(new Post("Post 1", "A new post using MVVM!", "kanishk"));
        list.add(new Post("Post 2", "A second post using MVVM!", "kanishk"));
        list.add(new Post("Post 3", "A third post using MVVM!", "kanishk"));
        list.add(new Post("Post 4", "A fourth post using MVVM!", "kanishk"));
        list.add(new Post("Post 5", "A fifth post using MVVM!", "kanishk"));
        PostEventModel eventModel = new PostEventModel(list);
        events.onDataReceived(eventModel);
    }

    public static void getNewPosts(Context c) {
        PostEvent events = (PostEvent) c;
        ArrayList<Post> list = new ArrayList<>();
        list.add(new Post("Post 1", "A new post using MVVM!", "kanishk"));
        PostEventModel eventModel = new PostEventModel(list);
        events.onDataUpdate(eventModel);
    }
}
