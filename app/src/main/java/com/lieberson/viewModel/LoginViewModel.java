package com.lieberson.viewModel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.lieberson.interfaceCallback.LoginResultCallbacks;
import com.lieberson.loginmvvm.model.User;

public class LoginViewModel extends ViewModel {

    private User mUser;
    private LoginResultCallbacks mResultCallbacks;

    public LoginViewModel(LoginResultCallbacks loginResultCallbacks){
        this.mResultCallbacks = loginResultCallbacks;
        this.mUser = new User();
    }

    public TextWatcher getEmailTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mUser.setEmail(s.toString());

            }
        };
    }

    public TextWatcher getPasswordTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mUser.setPassword(s.toString());
            }
        };
    }

    public void onLoginClicked(View view){
        int errorCode = mUser.isValidData();

        if (errorCode == 0)
            mResultCallbacks.onError("You must enter email address");
        else if (errorCode == 1)
            mResultCallbacks.onError("You must enter password ");
        else if (errorCode == 2)
            mResultCallbacks.onError("Your email is invalid");
        else if (errorCode == 3)
            mResultCallbacks.onError("Password length must greater than 6 characters");
        else
            mResultCallbacks.onSuccess("Login Success");
    }
}
