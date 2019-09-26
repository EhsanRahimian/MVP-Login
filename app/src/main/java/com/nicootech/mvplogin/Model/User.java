package com.nicootech.mvplogin.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User implements IUser {
    private  String email,password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
        //0. check email is empty;
        //1. check email is matches pattern;
        //2. check password length >=8;
//        return !TextUtils.isEmpty(getEmail())&&
//                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
//                getPassword().length()>=8;
//    }
        if (TextUtils.isEmpty(getEmail()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if (getPassword().length() < 7)
            return 2;
        else
            return -1;
    }

}
