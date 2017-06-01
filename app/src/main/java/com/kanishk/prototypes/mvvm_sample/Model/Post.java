package com.kanishk.prototypes.mvvm_sample.Model;

/**
 * Created by kanishk on 31/05/17.
 */

public class Post {

    public String title;
    public String description;
    public String postedByUsername;

    public Post(String title, String description, String postedByUsername) {
        this.title = title;
        this.description = description;
        this.postedByUsername = postedByUsername;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPostedByUsername() {
        return postedByUsername;
    }

}
