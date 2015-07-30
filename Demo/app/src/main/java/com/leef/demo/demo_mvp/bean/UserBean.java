package com.leef.demo.demo_mvp.bean;

/**
 * Created by Administrator on 2015/7/27.
 * MVP 设计模式的 BEAN 对象
 */
public class UserBean {
    private String mFirstName;
    private String mLastName;

    public UserBean(String firstName, String lastName) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }
}
