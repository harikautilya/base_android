package com.company.name.utils;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;


public class Utils {

    public static ProgressDialog showLoadingDialog(Context context, String title, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    public static boolean isOnline(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        //should check null because in airplane mode it will be null
        return (netInfo != null && netInfo.isConnected());
    }


    public static void showTimePicker(Context context, final OnSelectedTime onSelectedTime) {


        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                onSelectedTime.onSelected(selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }


    public static void showDatePicker(Context context, final OnSelectedTime onSelectedTime) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                onSelectedTime.onSelected(year + "/" + month + "/" + dayOfMonth);

            }
        }, year, month, day).show();

    }


    public static void showDateAndTime(final Context context, final OnSelectedTime onSelectedTime) {

        showDatePicker(context, new OnSelectedTime() {
            @Override
            public void onSelected(final String date) {
                final String[] data = {date};
                showTimePicker(context, new OnSelectedTime() {
                    @Override
                    public void onSelected(String query) {
                        data[0] +=":"+ query;
                        onSelectedTime.onSelected(data[0]);

                    }
                });

            }
        });
    }

    public interface OnSelectedTime {
        void onSelected(String query);
    }
}
