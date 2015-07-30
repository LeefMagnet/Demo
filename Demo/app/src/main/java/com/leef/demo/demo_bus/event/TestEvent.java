package com.leef.demo.demo_bus.event;

/**
 * Created by Administrator on 2015/7/24.
 */
public class TestEvent {
    private String what;

    public TestEvent(String what) {
        this.what = what;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }
}
