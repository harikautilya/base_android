package com.company.name.ui.main;

import android.content.Context;
import android.os.Bundle;

import com.company.name.Base.Classes.BaseViewModel;
import com.company.name.Base.DataManager;
import com.company.name.Base.rx.SchedulerProvider;
import com.company.name.storage.BaseDataPackage;


public class MainViewModel extends BaseViewModel<MainNavigator> {

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider, BaseDataPackage baseDataPackage) {
        super(dataManager, schedulerProvider, baseDataPackage);
    }

    @Override
    public void init(Bundle savedInstanceState, Context context) {

    }
}
