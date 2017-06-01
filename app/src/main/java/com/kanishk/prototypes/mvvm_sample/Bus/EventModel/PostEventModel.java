package com.kanishk.prototypes.mvvm_sample.Bus.EventModel;

import com.kanishk.prototypes.mvvm_sample.Model.Post;
import java.util.ArrayList;

/**
 * Created by kanishk on 31/05/17.
 */

public class PostEventModel {

    private ArrayList<Post> posts;

    public PostEventModel(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }
}
