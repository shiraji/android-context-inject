package com.github.shiraji.android_context_inject.di;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ActivityModule_ProvideContextFactory implements Factory<Context> {
  private final ActivityModule module;

  public ActivityModule_ProvideContextFactory(ActivityModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public Context get() {  
    Context provided = module.provideContext();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Context> create(ActivityModule module) {  
    return new ActivityModule_ProvideContextFactory(module);
  }
}

