package com.company.name;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;


import com.company.name.Base.DataManager;
import com.company.name.Base.Dependices.Components.ApplicationComponent;
import com.company.name.Base.Dependices.Components.DaggerApplicationComponent;
import com.company.name.Base.Dependices.Modules.ApplicationModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by Kautilya on 10-05-2018.
 */
public class App extends Application implements HasActivityInjector {
    static App instance;
    @Inject
    DataManager dataManager;
    protected ApplicationComponent applicationComponent;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }


}
