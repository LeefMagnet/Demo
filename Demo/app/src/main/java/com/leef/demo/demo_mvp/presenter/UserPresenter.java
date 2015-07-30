package com.leef.demo.demo_mvp.presenter;

import com.leef.demo.demo_mvp.bean.UserBean;
import com.leef.demo.demo_mvp.model.IUserModel;
import com.leef.demo.demo_mvp.model.UserModel;
import com.leef.demo.demo_mvp.view.IUserView;

/**
 * Created by Administrator on 2015/7/27.
 */
public class UserPresenter {
    private IUserView mUserView;
    private IUserModel mUserModel;

    public UserPresenter(IUserView view) {
        mUserView = view;
        mUserModel = new UserModel();
    }

    public void saveUser(int id, String firstName, String lastName) {
        mUserModel.setID(id);
        mUserModel.setFirstName(firstName);
        mUserModel.setLastName(lastName);
    }

    public void loadUser(int id) {
        UserBean user = mUserModel.load(id);
        mUserView.setFirstName(user.getFirstName());//通过调用IUserView的方法来更新显示
        mUserView.setLastName(user.getLastName());
    }
}
