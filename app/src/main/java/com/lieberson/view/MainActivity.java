package com.lieberson.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.lieberson.interfaceCallback.LoginResultCallbacks;
import com.lieberson.loginmvvm.R;
import com.lieberson.loginmvvm.databinding.ActivityMainBinding;
import com.lieberson.viewModel.LoginViewModel;
import com.lieberson.viewModel.LoginViewModelFactory;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(
                this,
                new LoginViewModelFactory(this)).get(LoginViewModel.class)
        );
    }

    @Override
    public void onSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String messageError) {
        Toasty.error(this, messageError, Toast.LENGTH_SHORT).show();

    }
}
