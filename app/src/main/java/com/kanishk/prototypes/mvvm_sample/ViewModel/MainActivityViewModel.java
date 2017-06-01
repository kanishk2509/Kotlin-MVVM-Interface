package com.kanishk.prototypes.mvvm_sample.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.kanishk.prototypes.mvvm_sample.Data.PostDataManager;

/**
 * Created by kanishk on 31/05/17.
 */

public class MainActivityViewModel extends BaseObservable {

    private Context context;

    public MainActivityViewModel(Context context) {
        this.context = context;
    }

    public View.OnClickListener onClickAddPost() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostDataManager.getNewPosts(context);
            }
        };
    }
}
