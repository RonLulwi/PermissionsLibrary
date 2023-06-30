package com.ronlu.permissionslibrary;

import android.app.Activity;

public class PermissionBuilder {
    private String positiveDialogButton = "Grant";
    private String negativeDialogButton = "Deny";
    private String rationaleMessage;
    private String title;
    private String permissionAsString;
    private int requestCode;
    private String grantManualPermissionMessage;

    public PermissionBuilder(PermissionType type, Activity activity) {
        this.permissionAsString = activity.getResources().getStringArray(R.array.permissionsId_array)[type.ordinal()];
        this.requestCode = type.ordinal();
        this.title = activity.getResources().getStringArray(R.array.permissionTitle_array)[type.ordinal()];
        this.rationaleMessage = activity.getResources().getStringArray(R.array.rationaleMessage_array)[type.ordinal()];
        this.grantManualPermissionMessage = "It seems you permanently declined this permission.\npress \"Grant\" to go to the App settings and grant it manually.";
    }
    public String getRationaleMessage() {
        return rationaleMessage;
    }
    public String getTitle() {
        return title;
    }
    public String getGrantManualPermissionMessage() {
        return grantManualPermissionMessage;
    }
    public String getPositiveDialogButton() {
        return positiveDialogButton;
    }
    public String getNegativeDialogButton() {
        return negativeDialogButton;
    }
    public String getPermissionAsString() {
        return permissionAsString;
    }
    public int getRequestCode() {
        return requestCode;
    }


    public PermissionBuilder setRationaleMessage(String rationaleMessage) {
        this.rationaleMessage = rationaleMessage;
        return this;
    }
    public PermissionBuilder setTitle(String title) {
        this.title = title;
        return this;
    }
    public PermissionBuilder setGrantManualPermissionMessage(String grantManualPermissionMessage) {
        this.grantManualPermissionMessage = grantManualPermissionMessage;
        return this;
    }
    public PermissionBuilder setPositiveDialogButton(String positiveDialogButton) {
        this.positiveDialogButton = positiveDialogButton;
        return this;
    }
    public PermissionBuilder setNegativeDialogButton(String negativeDialogButton) {
        this.negativeDialogButton = negativeDialogButton;
        return this;
    }

    @Override
    public String toString() {
        return "PermissionBuilder{" +
                "positiveDialogButton='" + positiveDialogButton + '\'' +
                ", negativeDialogButton='" + negativeDialogButton + '\'' +
                ", rationaleMessage='" + rationaleMessage + '\'' +
                ", title='" + title + '\'' +
                ", permissionAsString='" + permissionAsString + '\'' +
                ", requestCode=" + requestCode +
                ", grantManualPermissionMessage='" + grantManualPermissionMessage + '\'' +
                '}';
    }
}
