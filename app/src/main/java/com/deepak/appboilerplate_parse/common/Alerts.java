package com.deepak.appboilerplate_parse.common;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class Alerts {

    public static AlertDialog.Builder alertMessage(Context context,String title,String message){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message);
        return alertDialogBuilder;
    }

    public static void toastMessage(Context context,String message){
        toastMessageShort(context,message);
    }

    public static void toastMessageShort(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void toastMessageLong(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
