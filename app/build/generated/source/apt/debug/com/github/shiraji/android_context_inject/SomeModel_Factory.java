package com.github.shiraji.android_context_inject;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SomeModel_Factory implements Factory<SomeModel> {
  private final Provider<Context> applicationContextProvider;
  private final Provider<Context> activityContextProvider;

  public SomeModel_Factory(Provider<Context> applicationContextProvider, Provider<Context> activityContextProvider) {  
    assert applicationContextProvider != null;
    this.applicationContextProvider = applicationContextProvider;
    assert activityContextProvider != null;
    this.activityContextProvider = activityContextProvider;
  }

  @Override
  public SomeModel get() {  
    return new SomeModel(applicationContextProvider.get(), activityContextProvider.get());
  }

  public static Factory<SomeModel> create(Provider<Context> applicationContextProvider, Provider<Context> activityContextProvider) {  
    return new SomeModel_Factory(applicationContextProvider, activityContextProvider);
  }
}

