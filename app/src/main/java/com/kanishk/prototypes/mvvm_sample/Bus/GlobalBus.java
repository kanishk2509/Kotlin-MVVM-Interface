package com.kanishk.prototypes.mvvm_sample.Bus;

import com.squareup.otto.Bus;

/**
 * Created by kanishk on 31/05/17.
 */

public class GlobalBus {
    private static Bus sBus;
    public static Bus getBus() {
        if (sBus == null)
            sBus = new Bus();
        return sBus;
    }
}
