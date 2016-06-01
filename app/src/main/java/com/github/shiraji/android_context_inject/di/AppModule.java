package com.github.shiraji.android_context_inject.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(Application app) {
        context = app;
    }

    @Named("applicationContext")
    @Provides
    public Context provideContext() {
        return context;
    }
}
