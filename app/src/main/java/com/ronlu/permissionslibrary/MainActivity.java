package com.ronlu.permissionslibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Permissions permissions;
    private AppCompatButton CAMERA, READ_CONTACTS, RECORD_AUDIO, ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION, READ_SMS
            , SEND_SMS, RECEIVE_SMS, CALL_PHONE, READ_CALENDAR, WRITE_CALENDAR, READ_PHONE_STATE
            , GET_ACCOUNTS, WRITE_CONTACTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init permissions library with context, activity
        permissions = new Permissions(this, this);
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
        CAMERA.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.CAMERA));
        READ_CONTACTS.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.READ_CONTACTS));
        RECORD_AUDIO.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.RECORD_AUDIO));
        ACCESS_FINE_LOCATION.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.ACCESS_FINE_LOCATION));
        ACCESS_COARSE_LOCATION.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.ACCESS_COARSE_LOCATION));
        READ_SMS.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.READ_SMS));
        SEND_SMS.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.SEND_SMS));
        RECEIVE_SMS.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.RECEIVE_SMS));
        CALL_PHONE.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.CALL_PHONE));
        READ_CALENDAR.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.READ_CALENDAR));
        WRITE_CALENDAR.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.WRITE_CALENDAR));
        READ_PHONE_STATE.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.READ_PHONE_STATE));
        GET_ACCOUNTS.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.GET_ACCOUNTS));
        WRITE_CONTACTS.setOnClickListener(v -> permissions.permissionHandler(Permissions.permissionTypes.WRITE_CONTACTS));

    }

    @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            this.permissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

}