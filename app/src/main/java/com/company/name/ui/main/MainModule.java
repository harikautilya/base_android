package com.company.name.ui.main;


import com.company.name.Base.DataManager;
import com.company.name.Base.rx.SchedulerProvider;
import com.company.name.storage.BaseDataPackage;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {


    @Provides
    MainViewModel provideViewModel(DataManager dataManager, SchedulerProvider schedulerProvider, BaseDataPackage baseDataPackage) {
        return new MainViewModel(dataManager, schedulerProvider, baseDataPackage);
    }

    @Provides
    MainNavigator provideMainNavogator(MainActivity mainActivity) {
        return mainActivity;
    }
}
