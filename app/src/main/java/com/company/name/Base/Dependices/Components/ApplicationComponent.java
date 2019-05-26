package com.company.name.Base.Dependices.Components;

import android.app.Application;
import android.content.Context;

import com.company.name.App;
import com.company.name.Base.DBHelper;
import com.company.name.Base.DataManager;
import com.company.name.Base.Dependices.ActivityBuilder;
import com.company.name.Base.Dependices.Modules.ApplicationModule;
import com.company.name.Base.SharedPrefs;
import com.company.name.Base.annotations.ApplicationContext;
import com.company.name.storage.BaseDataPackage;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;



/**
 * Created by kautilya on 31/01/18.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AndroidSupportInjectionModule.class, ActivityBuilder.class, ApplicationModule.class})
public interface ApplicationComponent {


    void inject(App demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefs getPreferenceHelper();

    DBHelper getDbHelper();

    BaseDataPackage getBaseDataPackage();
}
