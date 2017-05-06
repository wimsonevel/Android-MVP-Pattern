package com.wimsonevel.androidmvp.presenter;

import com.wimsonevel.androidmvp.R;
import com.wimsonevel.androidmvp.model.User;
import com.wimsonevel.androidmvp.view.LoginView;

/**
 * Created by Wim on 1/1/17.
 */

public class LoginPresenter implements BasePresenter<LoginView> {

    private LoginView loginView;

    @Override
    public void attachView(LoginView view) {
        this.loginView = view;
    }

    @Override
    public void detachView() {
        this.loginView = null;
    }

    @Override
    public boolean isViewAttached() {
        return loginView != null;
    }

    public void doLogin(String email, String password) {
        loginView.showProgress();

        if(email.equals("example@mail.com") && password.equals("wim")) {
            loginView.hideProgress();
            loginView.onSuccess(new User(email));
        }else{
            loginView.hideProgress();
            loginView.onFailed(loginView.getContext().getResources().getString(R.string.login_failed));
        }

    }
}
