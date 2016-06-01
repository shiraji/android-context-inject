package com.github.shiraji.android_context_inject.di;

import com.github.shiraji.android_context_inject.MainActivity;
import com.github.shiraji.android_context_inject.di.scope.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity activity);

    FragmentComponent plus(FragmentModule module);
}