package com.company.name.ui.login;

import android.content.Context;
import android.os.Bundle;

import com.company.name.Base.Classes.BaseViewModel;
import com.company.name.Base.DataManager;
import com.company.name.Base.rx.SchedulerProvider;
import com.company.name.storage.BaseDataPackage;
import com.company.name.ui.main.MainActivity;

/**
 * Created by Kautilya on 10-05-2018.
 */
public class LoginViewModel extends BaseViewModel<LoginNavigator> {


    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider, BaseDataPackage baseDataPackage) {
        super(dataManager, schedulerProvider, baseDataPackage);
    }

    @Override
    public void init(Bundle savedInstanceState, Context context) {

        getSchedulerProvider().io().createWorker().schedule(new Runnable() {
            @Override
            public void run() {

                // Request data from database

            }
        });

        getSchedulerProvider().ui().createWorker().schedule(new Runnable() {
            @Override
            public void run() {
                // make a ui change if necessary
            }
        });

        getSchedulerProvider().computation().createWorker().schedule(new Runnable() {
            @Override
            public void run() {
                // make a really long computation
            }
        });


    }

    public void login() {
        getNavigator().pushToActivity(MainActivity.class);
    }
}
