package com.kanishk.prototypes.mvvm_sample.Bus.Event

import com.kanishk.prototypes.mvvm_sample.Bus.EventModel.PostEventModel
import com.squareup.otto.Subscribe

/**
 * Created by kanishk on 31/05/17.
 */

interface PostEvent {

    @Subscribe
    fun onDataReceived(eventModel: PostEventModel)

    @Subscribe
    fun onDataUpdate(eventModel: PostEventModel)

}
