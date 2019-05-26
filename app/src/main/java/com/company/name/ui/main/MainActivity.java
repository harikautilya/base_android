package com.company.name.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.company.name.BR;
import com.company.name.Base.Classes.BaseActivity;
import com.company.name.R;
import com.company.name.databinding.ActivityMainBinding;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel, MainNavigator> implements MainNavigator {
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public int getViewModelId() {
        return BR.mainViewModel;
    }

    @Override
    public void init(@Nullable Bundle savedInstanceState) {


    }
}
