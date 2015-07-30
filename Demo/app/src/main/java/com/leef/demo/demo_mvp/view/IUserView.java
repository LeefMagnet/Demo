package com.leef.demo.demo_mvp.view;

/**
 * Created by Administrator on 2015/7/27.
 * 视图的接口
 */
public interface IUserView {
    int getID();

    String getFirstName();

    String getLastName();

    void setFirstName(String firstName);

    void setLastName(String lastName);
}
