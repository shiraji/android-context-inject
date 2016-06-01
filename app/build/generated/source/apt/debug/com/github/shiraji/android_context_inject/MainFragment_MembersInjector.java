package com.github.shiraji.android_context_inject;

import android.content.Context;
import android.support.v4.app.Fragment;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainFragment_MembersInjector implements MembersInjector<MainFragment> {
  private final MembersInjector<Fragment> supertypeInjector;
  private final Provider<Context> applicationContextProvider;
  private final Provider<Context> activityContextProvider;
  private final Provider<Context> fragmentContextProvider;

  public MainFragment_MembersInjector(MembersInjector<Fragment> supertypeInjector, Provider<Context> applicationContextProvider, Provider<Context> activityContextProvider, Provider<Context> fragmentContextProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert applicationContextProvider != null;
    this.applicationContextProvider = applicationContextProvider;
    assert activityContextProvider != null;
    this.activityContextProvider = activityContextProvider;
    assert fragmentContextProvider != null;
    this.fragmentContextProvider = fragmentContextProvider;
  }

  @Override
  public void injectMembers(MainFragment instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.applicationContext = applicationContextProvider.get();
    instance.activityContext = activityContextProvider.get();
    instance.fragmentContext = fragmentContextProvider.get();
  }

  public static MembersInjector<MainFragment> create(MembersInjector<Fragment> supertypeInjector, Provider<Context> applicationContextProvider, Provider<Context> activityContextProvider, Provider<Context> fragmentContextProvider) {  
      return new MainFragment_MembersInjector(supertypeInjector, applicationContextProvider, activityContextProvider, fragmentContextProvider);
  }
}

