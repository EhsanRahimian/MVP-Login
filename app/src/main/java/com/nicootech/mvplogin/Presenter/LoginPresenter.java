package com.nicootech.mvplogin.Presenter;

import com.nicootech.mvplogin.Model.User;
import com.nicootech.mvplogin.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email,password);
        int loginCode = user.isValidData();

        if(loginCode==0)
            loginView.onLoginError("Please Enter Your Email");
        else if(loginCode==1)
            loginView.onLoginError("Please Enter Valid Email");
        else if(loginCode==2)
            loginView.onLoginError("Password length must be at least 8 characters");
        else
            loginView.onLoginSuccess("Login success");
    }
}
