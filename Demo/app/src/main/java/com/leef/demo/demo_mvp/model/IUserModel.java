package com.leef.demo.demo_mvp.model;

import com.leef.demo.demo_mvp.bean.UserBean;

/**
 * Created by Administrator on 2015/7/27.
 */
public interface IUserModel {
    void setID(int id);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    int getID();

    UserBean load(int id);//通过id读取user信息,返回一个UserBean
}
