package com.kanishk.prototypes.mvvm_sample.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;
import android.widget.Toast;

import com.kanishk.prototypes.mvvm_sample.Model.Post;

/**
 * Created by kanishk on 31/05/17.
 */

public class PostViewModel extends BaseObservable {

    private Context context;
    private Post post;

    public PostViewModel(Context context, Post post) {
        this.context = context;
        this.post = post;
    }

    public String getPostTitle() {
        return post.getTitle();
    }

    public String getPostAuthor() {
        return post.getPostedByUsername();
    }

    public String getPostDescription() {
        return post.getDescription();
    }

    public View.OnClickListener onClickPost() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayHello();
            }
        };
    }

    private void sayHello() {
        Toast.makeText(context, "Hello there!", Toast.LENGTH_SHORT).show();
    }
}