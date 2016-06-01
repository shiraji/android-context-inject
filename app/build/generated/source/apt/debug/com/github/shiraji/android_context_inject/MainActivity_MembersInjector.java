package com.github.shiraji.android_context_inject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final MembersInjector<AppCompatActivity> supertypeInjector;
  private final Provider<Context> applicationContextProvider;
  private final Provider<Context> activityContextProvider;
  private final Provider<SomeModel> someModelProvider;

  public MainActivity_MembersInjector(MembersInjector<AppCompatActivity> supertypeInjector, Provider<Context> applicationContextProvider, Provider<Context> activityContextProvider, Provider<SomeModel> someModelProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert applicationContextProvider != null;
    this.applicationContextProvider = applicationContextProvider;
    assert activityContextProvider != null;
    this.activityContextProvider = activityContextProvider;
    assert someModelProvider != null;
    this.someModelProvider = someModelProvider;
  }

  @Override
  public void injectMembers(MainActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.applicationContext = applicationContextProvider.get();
    instance.activityContext = activityContextProvider.get();
    instance.someModel = someModelProvider.get();
  }

  public static MembersInjector<MainActivity> create(MembersInjector<AppCompatActivity> supertypeInjector, Provider<Context> applicationContextProvider, Provider<Context> activityContextProvider, Provider<SomeModel> someModelProvider) {  
      return new MainActivity_MembersInjector(supertypeInjector, applicationContextProvider, activityContextProvider, someModelProvider);
  }
}

