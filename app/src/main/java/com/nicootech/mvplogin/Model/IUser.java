package com.nicootech.mvplogin.Model;

public interface IUser {
    String getEmail();
    String getPassword();
    boolean isValidData(String email, String password);
}