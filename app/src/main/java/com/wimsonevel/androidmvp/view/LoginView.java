package com.wimsonevel.androidmvp.view;

import com.wimsonevel.androidmvp.model.User;

/**
 * Created by Wim on 1/1/17.
 */

public interface LoginView extends BaseView {

    void onSuccess(User user);
    void onFailed(String msg);

    void showProgress();
    void hideProgress();
}