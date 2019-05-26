package com.company.name.Base;

import android.content.Context;
import android.content.SharedPreferences;

import com.company.name.App;

import javax.inject.Inject;
import javax.inject.Singleton;



@Singleton
public class SharedPrefs {
    private static String LOG_TAG = SharedPrefs.class.getName();
    private static SharedPreferences sp = null;
    private static final String spInstant = "AppPref";
    private static SharedPreferences.Editor editor = null;

    private static SharedPreferences.Editor getEditor() {
        if (editor == null) {
            editor = getSP().edit();
        }
        return editor;
    }

    public static void init(Context context) {
        if (context != null) {
            sp = context.getSharedPreferences(spInstant, Context.MODE_PRIVATE);
            editor = sp.edit();
        }
    }

    @Inject
    public SharedPrefs(SharedPreferences sharedPreferences) {
        sp = sharedPreferences;
    }
    private static SharedPreferences getSP() {
        if (sp == null) {
            init(App.getInstance());
        }
        return sp;
    }



}
