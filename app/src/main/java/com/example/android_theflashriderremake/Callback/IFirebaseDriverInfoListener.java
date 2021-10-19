package com.example.android_theflashriderremake.Callback;

import com.example.android_theflashriderremake.Model.DriverGeoModel;

public interface IFirebaseDriverInfoListener {
    void onDriverInfoLoadSuccess(DriverGeoModel driverGeoModel);
}
