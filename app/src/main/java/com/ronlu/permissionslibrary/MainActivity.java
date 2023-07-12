package com.ronlu.permissionslibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Permissions permissions;
    private PermissionBuilder cameraBuilder;
    private AppCompatButton CAMERA, READ_CONTACTS, RECORD_AUDIO, ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION, READ_SMS
            , SEND_SMS, RECEIVE_SMS, CALL_PHONE, READ_CALENDAR, WRITE_CALENDAR, READ_PHONE_STATE
            , GET_ACCOUNTS, WRITE_CONTACTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init Permissions using context and activity
        permissions = new Permissions(this, this);
        // Init and modify PermissionBuilder with PermissionType enum class and activity
        cameraBuilder = new PermissionBuilder(PermissionType.CAMERA,this);
        // Set your builder attributes for custom alert dialog display
        cameraBuilder.setTitle("Custom title")
                .setRationaleMessage("Custom rational message")
                .setPositiveDialogButton("Custom positive button")
                .setNegativeDialogButton("Custom negative button")
                .setGrantManualPermissionMessage("Custom message");

        findViews();
        initViews();
    }

    private void findViews() {
        CAMERA = findViewById(R.id.CAMERA);
        READ_CONTACTS = findViewById(R.id.READ_CONTACTS);
        RECORD_AUDIO = findViewById(R.id.RECORD_AUDIO);
        ACCESS_FINE_LOCATION = findViewById(R.id.ACCESS_FINE_LOCATION);
        ACCESS_COARSE_LOCATION = findViewById(R.id.ACCESS_COARSE_LOCATION);
        READ_SMS = findViewById(R.id.READ_SMS);
        SEND_SMS = findViewById(R.id.SEND_SMS);
        RECEIVE_SMS = findViewById(R.id.RECEIVE_SMS);
        CALL_PHONE = findViewById(R.id.CALL_PHONE);
        READ_CALENDAR = findViewById(R.id.READ_CALENDAR);
        WRITE_CALENDAR = findViewById(R.id.WRITE_CALENDAR);
        READ_PHONE_STATE = findViewById(R.id.READ_PHONE_STATE);
        GET_ACCOUNTS = findViewById(R.id.GET_ACCOUNTS);
        WRITE_CONTACTS = findViewById(R.id.WRITE_CONTACTS);

    }
    private void initViews() {
        // Use the Library with custom builder.
        CAMERA.setOnClickListener(v -> permissions.requestPermission(cameraBuilder));
        // Use the Library with hard coded alert dialog messages.

        READ_CONTACTS.setOnClickListener(v -> permissions.requestPermission(new PermissionBuilder(PermissionType.READ_CONTACTS, this)));
        RECORD_AUDIO.setOnClickListener(v -> permissions.requestPermission(new PermissionBuilder(PermissionType.RECORD_AUDIO, this)));
        ACCESS_FINE_LOCATION.setOnClickListener(v -> permissions.requestPermission(new PermissionBuilder(PermissionType.ACCESS_FINE_LOCATION, this)));
        ACCESS_COARSE_LOCATION.setOnClickListener(v -> permissions.requestPermission(new PermissionBuilder(PermissionType.ACCESS_COARSE_LOCATION, this)));
        READ_SMS.setOnClickListener(v -> permissions.requestPermission(new PermissionBuilder(PermissionType.READ_SMS, this)));
        SEND_SMS.setOnClickListener(v -> permissions.requestPermission(new PermissionBuilder(PermissionType.SEND_SMS, this)));
        RECEIVE_SMS.setOnClickListener(v -> permissions.requestPermission(new PermissionBuilder(PermissionType.RECEIVE_SMS, this)));
        CALL_PHONE.setOnClickListener(v -> permissions.requestPermission(new PermissionBuilder(PermissionType.CALL_PHONE, this)));
        READ_CALENDAR.setOnClickListener(v -> permissions.requestPermission(new PermissionBuilder(PermissionType.READ_CALENDAR, this)));
        WRITE_CALENDAR.setOnClickListener(v -> permissions.requestPermission(new PermissionBuilder(PermissionType.WRITE_CALENDAR, this)));
        READ_PHONE_STATE.setOnClickListener(v -> permissions.requestPermission(new PermissionBuilder(PermissionType.READ_PHONE_STATE, this)));
        GET_ACCOUNTS.setOnClickListener(v -> permissions.requestPermission(new PermissionBuilder(PermissionType.GET_ACCOUNTS, this)));
        WRITE_CONTACTS.setOnClickListener(v -> permissions.requestPermission(new PermissionBuilder(PermissionType.WRITE_CONTACTS, this)));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        this.permissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}