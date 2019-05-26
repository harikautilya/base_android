package com.company.name.Base.Classes;

import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by kautilya on 05/02/18.
 */

public interface BaseNavigator {


    void displayMessage(boolean success, String message);

    void showLoading(String title, String message);

    void hideLoading();

    void showToast(String message);

    void showAlertDialog(String title, String message, String positiveText, DialogInterface.OnClickListener pClickListener, String negative, DialogInterface.OnClickListener nClickListener);

    <T extends BaseActivity> void pushToActivity(Class<T> tClass);

    void finish();

    Context getContext();
}
