package com.company.name.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.company.name.BR;
import com.company.name.Base.Classes.BaseActivity;
import com.company.name.R;
import com.company.name.databinding.ActivityLoginBinding;


public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel, LoginNavigator> implements LoginNavigator {


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public int getViewModelId() {
        return BR.login_view;
    }

    @Override
    public void init(@Nullable Bundle savedInstanceState) {

    }


}
