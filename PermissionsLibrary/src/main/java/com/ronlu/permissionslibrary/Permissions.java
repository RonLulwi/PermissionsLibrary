package com.ronlu.permissionslibrary;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

public class Permissions implements ActivityCompat.OnRequestPermissionsResultCallback {

    public enum permissionTypes {CAMERA, READ_CONTACTS, RECORD_AUDIO, ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION, READ_SMS
        , SEND_SMS, RECEIVE_SMS, CALL_PHONE, READ_CALENDAR, WRITE_CALENDAR, READ_PHONE_STATE
        , GET_ACCOUNTS, WRITE_CONTACTS};
    private Context context;
    private Activity activity;
    public Permissions(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public void permissionHandler(permissionTypes type){
        String permissionId = activity.getResources().getStringArray(R.array.permissionsIds)[type.ordinal()];
        if(ActivityCompat.checkSelfPermission(context, permissionId) != PackageManager.PERMISSION_GRANTED){
            int requestCode = type.ordinal();
            ActivityCompat.requestPermissions(activity, new String[]{permissionId}, requestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        String permissionId = activity.getResources().getStringArray(R.array.permissionsIds)[requestCode];;
        if(grantResults[0] != PackageManager.PERMISSION_GRANTED){
            String title = activity.getResources().getStringArray(R.array.titles)[requestCode];
            if(ActivityCompat.shouldShowRequestPermissionRationale(activity, permissionId))
                showRationalDialog(permissionId, requestCode, title);
            else
                showManualDialog(title);
        }
    }


    private void showRationalDialog(String permissionId, int requestCode, String title) {
        String message = activity.getResources().getStringArray(R.array.messages)[requestCode];
        showCustomDialog(title, message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{permissionId}, requestCode);
            }
        });

    }
    private void showManualDialog(String title) {
        String message = "It seems you permanently declined this permission.\npress \"Grant\" to go to the App settings and grant it manually.";
        showCustomDialog(title, message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", context.getPackageName(), null));
                activity.startActivity(intent);
            }
        });

    }


    private void showCustomDialog(String title, String massage, DialogInterface.OnClickListener positiveListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title).setMessage(massage).setPositiveButton("Grant", positiveListener)
                .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        builder.setCancelable(false);
        builder.create().show();

    }








}
