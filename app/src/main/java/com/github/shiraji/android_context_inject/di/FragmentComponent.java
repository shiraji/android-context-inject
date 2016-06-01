package com.github.shiraji.android_context_inject.di;

import com.github.shiraji.android_context_inject.MainFragment;
import com.github.shiraji.android_context_inject.di.scope.FragmentScope;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {FragmentModule.class})
public interface FragmentComponent {

    void inject(MainFragment fragment);
}
