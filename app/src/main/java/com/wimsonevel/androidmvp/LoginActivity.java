package com.wimsonevel.androidmvp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wimsonevel.androidmvp.model.User;
import com.wimsonevel.androidmvp.presenter.LoginPresenter;
import com.wimsonevel.androidmvp.view.LoginView;

import static android.text.TextUtils.isEmpty;

/**
 * Created by Wim on 1/1/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText etEmail;
    private EditText etPassword;

    private LoginPresenter loginPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(this.getResources().getString(R.string.loading));
    }

    void loginAct(View view) {
        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(this);

        if(isEmpty(etEmail.getText().toString())) {
            return;
        }

        if(isEmpty(etPassword.getText().toString())) {
            return;
        }

        if(loginPresenter.isViewAttached()) {
            loginPresenter.doLogin(etEmail.getText().toString(), etPassword.getText().toString());
        }

    }

    @Override
    public void onSuccess(User user) {
        Toast.makeText(this, this.getResources().getString(R.string.login_success), Toast.LENGTH_SHORT).show();
        MainActivity.start(this, user);
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detachView();
    }
}
