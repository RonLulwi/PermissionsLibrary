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

    private PermissionBuilder currentBuilder;
    private final Context context;
    private final Activity activity;

    public Permissions(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }
    public void requestPermission(@NonNull PermissionBuilder builder){
        this.currentBuilder = builder;
        String permissionId = builder.getPermissionAsString();
        if(ActivityCompat.checkSelfPermission(context, permissionId) != PackageManager.PERMISSION_GRANTED){
            int requestCode = builder.getRequestCode();
            ActivityCompat.requestPermissions(activity, new String[]{permissionId}, requestCode);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        String permissionId = currentBuilder.getPermissionAsString();
        if(grantResults[0] != PackageManager.PERMISSION_GRANTED)
            if(ActivityCompat.shouldShowRequestPermissionRationale(activity, permissionId))
                showRationalDialog(permissionId, requestCode);
            else
                showManualDialog();
    }
    private void showRationalDialog(String permissionId, int requestCode) {
        String message = currentBuilder.getRationaleMessage();
        showCustomDialog(message, (dialog, which) -> ActivityCompat.requestPermissions((Activity) context, new String[]{permissionId}, requestCode));
    }
    private void showManualDialog() {
        String message = currentBuilder.getGrantManualPermissionMessage();
        showCustomDialog(message, (dialog, which) -> {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", context.getPackageName(), null));
            activity.startActivity(intent);
        });

    }


    private void showCustomDialog(String massage, DialogInterface.OnClickListener positiveListener){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder
                .setTitle(currentBuilder.getTitle())
                .setMessage(massage)
                .setPositiveButton(currentBuilder.getPositiveDialogButton(), positiveListener)
                .setNegativeButton(currentBuilder.getNegativeDialogButton(), (dialog, which) -> dialog.cancel());
        dialogBuilder.setCancelable(false);
        dialogBuilder.create().show();

    }
}
