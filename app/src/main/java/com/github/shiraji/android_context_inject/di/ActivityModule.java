package com.github.shiraji.android_context_inject.di;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Named("activityContext")
    @Provides
    public Context provideContext() {
        return activity;
    }
}
