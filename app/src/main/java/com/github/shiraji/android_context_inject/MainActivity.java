package com.github.shiraji.android_context_inject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    @Named("applicationContext")
    @Inject
    Context applicationContext;

    @Named("activityContext")
    @Inject
    Context activityContext;

    @Inject
    SomeModel someModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApplication.getComponent(this).inject(this);

        Log.d("MainActivity", "activityContext: " + activityContext);
        Log.d("MainActivity", "applicationContext: " + applicationContext);
    }
}
