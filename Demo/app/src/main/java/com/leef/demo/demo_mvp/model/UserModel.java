package com.leef.demo.demo_mvp.model;

import com.leef.demo.demo_mvp.bean.UserBean;

/**
 * Created by Administrator on 2015/7/27.
 */
public class UserModel implements IUserModel {
    @Override
    public void setID(int id) {

    }

    @Override
    public void setFirstName(String firstName) {

    }

    @Override
    public void setLastName(String lastName) {

    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public UserBean load(int id) {
        return new UserBean("first", "last");
    }
}
