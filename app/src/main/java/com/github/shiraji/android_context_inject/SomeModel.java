package com.github.shiraji.android_context_inject;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class SomeModel {
    @Inject
    public SomeModel(@Named("applicationContext") Context applicationContext, @Named("activityContext") Context activityContext) {
        Log.d("SomeModel", "applicationContext: " + applicationContext);
        Log.d("SomeModel", "activityContext: " + activityContext);
    }
}
