# Permissions Library
The Permissions Library is a powerful tool designed to handle user permissions in Android applications. It provides developers with the ability to manage and request permissions seamlessly, allowing for a smooth user experience. With this library, you can easily implement permission-related functionalities, including the option to use hardcoded AlertDialogs or build custom ones.

## Demonstration video
https://github.com/RonLulwi/PermissionsLibrary/assets/95926852/01cb21d4-e475-424c-baae-e98b770321cd

## Usage
To use the Permissions Library, follow the steps outlined below:

### Custom AlertDialog Display
1. Declare the necessary variables
   ```java
   Permissions permissions;
   PermissionBuilder cameraBuilder;
   ```
2. Initialize Permissions using the context and activity
   ```java
   permissions = new Permissions(this, this);
   ```
3. Initialize and modify PermissionBuilder with the appropriate PermissionType enum class and activity
   ```java
   cameraBuilder = new PermissionBuilder(PermissionType.CAMERA, this)
        .setTitle("Custom title")
        .setRationaleMessage("Custom rational message")
        .setPositiveDialogButton("Custom positive button")
        .setNegativeDialogButton("Custom negative button")
        .setGrantManualPermissionMessage("Custom message");
   ```
4. Override onRequestPermissionsResult and call permissions.onRequestPermissionsResult:
   ```java
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        this.permissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
   ```  
5. Use the library with a custom builder
   ```java
   CAMERA.setOnClickListener(v -> permissions.requestPermission(cameraBuilder));
   ```

### Hardcoded AlertDialog Messages
1. Declare the necessary variables
   ```java
   Permissions permissions;
   ```
2. Initialize Permissions using the context and activity
   ```java
   permissions = new Permissions(this, this);
   ```
3. Override onRequestPermissionsResult and call permissions.onRequestPermissionsResult:
   ```java
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        this.permissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
   ```
4. Use the library with hardcoded AlertDialog messages
   ```java
   READ_CONTACTS.setOnClickListener(v -> permissions.requestPermission(PermissionType.READ_CONTACTS));
   ```

By following these steps, you can easily integrate the Permissions Library into your Android application and handle user permissions efficiently. You can choose either the custom AlertDialog display approach or the hardcoded AlertDialog messages approach, depending on your specific requirements

## Supported Permissions with Hardcoded AlertDialog Messages
The Permissions Library supports the following permissions with hardcoded AlertDialog messages:

* android.permission.READ_CALENDAR
* android.permission.WRITE_CALENDAR
* android.permission.CAMERA
* android.permission.READ_CONTACTS
* android.permission.WRITE_CONTACTS
* android.permission.GET_ACCOUNTS
* android.permission.ACCESS_FINE_LOCATION
* android.permission.ACCESS_COARSE_LOCATION
* android.permission.ACCESS_BACKGROUND_LOCATION
* android.permission.RECORD_AUDIO
* android.permission.READ_PHONE_STATE
* android.permission.CALL_PHONE
* android.permission.READ_CALL_LOG
* android.permission.WRITE_CALL_LOG
* com.android.voicemail.permission.ADD_VOICEMAIL
* android.permission.USE_SIP
* android.permission.PROCESS_OUTGOING_CALLS
* android.permission.BODY_SENSORS
* android.permission.SEND_SMS
* android.permission.READ_SMS
* android.permission.RECEIVE_SMS
* android.permission.RECEIVE_WAP_PUSH
* android.permission.RECEIVE_MMS
* android.permission.READ_EXTERNAL_STORAGE
* android.permission.WRITE_EXTERNAL_STORAGE
* android.permission.BLUETOOTH_CONNECT
* android.permission.BLUETOOTH_SCAN
* android.permission.BLUETOOTH_ADVERTISE
* android.permission.ACCESS_MEDIA_LOCATION
* android.permission.ACCEPT_HANDOVER
* android.permission.ACTIVITY_RECOGNITION
* android.permission.ANSWER_PHONE_CALLS
* android.permission.READ_PHONE_NUMBERS
* android.permission.UWB_RANGING
* android.permission.BODY_SENSORS_BACKGROUND
* android.permission.READ_MEDIA_IMAGES
* android.permission.READ_MEDIA_VIDEO
* android.permission.READ_MEDIA_AUDIO
* android.permission.POST_NOTIFICATIONS
* android.permission.NEARBY_WIFI_DEVICES
* com.android.voicemail.permission.READ_VOICEMAIL
* com.android.voicemail.permission.WRITE_VOICEMAIL

You can use the Permissions Library to handle these permissions with ease by directly calling the respective permission types.
