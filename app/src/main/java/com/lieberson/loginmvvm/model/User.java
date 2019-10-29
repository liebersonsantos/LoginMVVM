package com.lieberson.loginmvvm.model;

import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;

import androidx.databinding.BaseObservable;

public class User extends BaseObservable {

    private String email;
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.email = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int isValidData() {
        if (TextUtils.isEmpty(getEmail()))
            return 0;
        else if (TextUtils.isEmpty(getPassword()))
            return 1;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 2;
        else if (getPassword().length() < 6)
            return 3;
        else
            return -1;
    }
}
