package com.google.firebase.codelab.friendlychat;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFMService";
    private static final String FRIENDLY_ENGAGE_TOPIC = "friendly_engage";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        // Handle data payload of FCM messages.
        Log.d(TAG, "FCM Message Id: "+remoteMessage.getMessageId());
        Log.d(TAG, "FCM Notification Message: "+remoteMessage.getNotification());
        Log.d(TAG, "FCM Data Message: "+remoteMessage.getData());
    }

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "FCM token: "+token);
        // Once a token is generated, we subscribe topic.
        FirebaseMessaging.getInstance().subscribeToTopic(FRIENDLY_ENGAGE_TOPIC);
    }
}
