package com.github.shiraji.android_context_inject;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.github.shiraji.android_context_inject.di.ActivityComponent;
import com.github.shiraji.android_context_inject.di.ActivityModule;
import com.github.shiraji.android_context_inject.di.AppComponent;
import com.github.shiraji.android_context_inject.di.AppModule;
import com.github.shiraji.android_context_inject.di.DaggerAppComponent;
import com.github.shiraji.android_context_inject.di.FragmentComponent;
import com.github.shiraji.android_context_inject.di.FragmentModule;

public class MyApplication extends Application {
    AppComponent appComponent;

    @NonNull
    public AppComponent getComponent() {
        return appComponent;
    }

    @NonNull
    public static AppComponent getComponent(Context context) {
        return ((MyApplication) context.getApplicationContext()).appComponent;
    }

    @NonNull
    public static FragmentComponent getComponent(Fragment fragment) {
        assert fragment.getActivity() != null;
        AppCompatActivity activity = (AppCompatActivity) fragment.getActivity();
        MyApplication application = (MyApplication) fragment.getContext().getApplicationContext();
        return application.appComponent
                .plus(new ActivityModule(activity))
                .plus(new FragmentModule(fragment));
    }

    @NonNull
    public static ActivityComponent getComponent(AppCompatActivity activity) {
        MyApplication application = (MyApplication) activity.getApplicationContext();
        return application.appComponent.plus(new ActivityModule(activity));
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
