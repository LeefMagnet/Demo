package com.leef.demo.demo_bus;

import com.squareup.otto.Bus;

/**
 * Created by Administrator on 2015/7/24.
 */
public final class BusProvider {
    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }

    private BusProvider() {
        // No instances.
    }
}
