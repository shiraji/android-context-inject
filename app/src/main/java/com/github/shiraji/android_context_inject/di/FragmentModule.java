package com.github.shiraji.android_context_inject.di;

import android.content.Context;
import android.support.v4.app.Fragment;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Named("fragmentContext")
    @Provides
    public Context provideContext() {
        return fragment.getContext();
    }
}