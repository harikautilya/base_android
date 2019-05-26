package com.company.name.Base.Dependices;

import com.company.name.ui.login.LoginActivity;
import com.company.name.ui.login.LoginModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;




/**
 * Created by kautilya on 01/02/18.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity provideLoginActivity();




}
