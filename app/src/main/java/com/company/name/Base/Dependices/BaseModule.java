package com.company.name.Base.Dependices;


import com.company.name.Base.Classes.BaseActivity;
import com.company.name.Base.Classes.BaseNavigator;
import com.company.name.Base.DataManager;
import com.company.name.Base.rx.SchedulerProvider;
import com.company.name.storage.BaseDataPackage;

public interface BaseModule<T, A extends BaseActivity,L extends BaseNavigator> {


    T provideViewModel(DataManager dataManager, SchedulerProvider schedulerProvider, BaseDataPackage baseDataPackage);

    L provideActivity(A activity);

}
