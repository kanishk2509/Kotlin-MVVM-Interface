package com.kanishk.prototypes.mvvm_sample.Bus.Event;

import com.kanishk.prototypes.mvvm_sample.Bus.EventModel.PostEventModel;
import com.squareup.otto.Subscribe;

/**
 * Created by kanishk on 31/05/17.
 */

public interface PostEvent {

    @Subscribe
    void onDataReceived(PostEventModel eventModel);

    @Subscribe
    void onDataUpdate(PostEventModel eventModel);

}
