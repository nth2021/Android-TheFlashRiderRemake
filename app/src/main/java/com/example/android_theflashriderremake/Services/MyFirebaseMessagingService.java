package com.example.android_theflashriderremake.Services;

import androidx.annotation.NonNull;

import com.example.android_theflashriderremake.Common.Common;
import com.example.android_theflashriderremake.Utils.UserUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;
import java.util.Random;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        if(FirebaseAuth.getInstance().getCurrentUser() != null){
            UserUtils.updateToken(this,s);
        }

    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Map<String,String> dataREcv = remoteMessage.getData();
        if(dataREcv !=null){
            Common.showNotification(this,new Random().nextInt(),
                    dataREcv.get(Common.NOTI_TITTLE),
                    dataREcv.get(Common.NOTI_CONTENT),
                    null);
        }
    }
}
