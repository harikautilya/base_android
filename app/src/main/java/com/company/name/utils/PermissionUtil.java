package com.company.name.utils;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

public class PermissionUtil {


    private PermissionUtil() {
        throw new AssertionError();
    }

    public static <T extends AppCompatActivity> boolean checkIfLocationPermissionIsGiven(
            final T activityRef) {
        if (ContextCompat.checkSelfPermission(activityRef, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            return true;
        }
    }


    public static  boolean checkIfStoragePermissionIsGiven(
            final Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            return true;
        }
    }

    public static <T extends AppCompatActivity> void requestForLocationPermission(final T activityRef,
                                                                                  final int permissionRequestCode) {
        ActivityCompat.requestPermissions(activityRef,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, permissionRequestCode);
    }

    public static <T extends AppCompatActivity> boolean shouldShowPermissionRationaleForLocation(T activity) {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION);
    }


    public static <T extends AppCompatActivity> void requestForStoragePermission(final T activityRef,
                                                                                 final int permissionRequestCode) {
        ActivityCompat.requestPermissions(activityRef,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, permissionRequestCode);
    }


    public static void requestForSettingsPermission(final Context activityRef) {
        Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
        intent.setData(Uri.parse("package:" + activityRef.getPackageName()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activityRef.startActivity(intent);
    }


}
