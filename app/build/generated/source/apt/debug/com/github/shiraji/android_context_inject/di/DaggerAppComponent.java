package com.github.shiraji.android_context_inject.di;

import android.content.Context;
import com.github.shiraji.android_context_inject.MainActivity;
import com.github.shiraji.android_context_inject.MainActivity_MembersInjector;
import com.github.shiraji.android_context_inject.MainFragment;
import com.github.shiraji.android_context_inject.MainFragment_MembersInjector;
import com.github.shiraji.android_context_inject.SomeModel;
import com.github.shiraji.android_context_inject.SomeModel_Factory;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerAppComponent implements AppComponent {
  private Provider<Context> provideContextProvider;

  private DaggerAppComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.provideContextProvider = AppModule_ProvideContextFactory.create(builder.appModule);
  }

  @Override
  public ActivityComponent plus(ActivityModule module) {  
    return new ActivityComponentImpl(module);
  }

  public static final class Builder {
    private AppModule appModule;
  
    private Builder() {  
    }
  
    public AppComponent build() {  
      if (appModule == null) {
        throw new IllegalStateException("appModule must be set");
      }
      return new DaggerAppComponent(this);
    }
  
    public Builder appModule(AppModule appModule) {  
      if (appModule == null) {
        throw new NullPointerException("appModule");
      }
      this.appModule = appModule;
      return this;
    }
  }

  private final class ActivityComponentImpl implements ActivityComponent {
    private final ActivityModule activityModule;
    private Provider<Context> provideContextProvider;
    private Provider<SomeModel> someModelProvider;
    private MembersInjector<MainActivity> mainActivityMembersInjector;
  
    private ActivityComponentImpl(ActivityModule activityModule) {  
      if (activityModule == null) {
        throw new NullPointerException();
      }
      this.activityModule = activityModule;
      initialize();
    }
  
    private void initialize() {  
      this.provideContextProvider = ActivityModule_ProvideContextFactory.create(activityModule);
      this.someModelProvider = SomeModel_Factory.create(DaggerAppComponent.this.provideContextProvider, provideContextProvider);
      this.mainActivityMembersInjector = MainActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), DaggerAppComponent.this.provideContextProvider, provideContextProvider, someModelProvider);
    }
  
    @Override
    public void inject(MainActivity activity) {  
      mainActivityMembersInjector.injectMembers(activity);
    }
  
    @Override
    public FragmentComponent plus(FragmentModule module) {  
      return new FragmentComponentImpl(module);
    }
  
    private final class FragmentComponentImpl implements FragmentComponent {
      private final FragmentModule fragmentModule;
      private Provider<Context> provideContextProvider;
      private MembersInjector<MainFragment> mainFragmentMembersInjector;
      private MembersInjector<MainActivity> mainActivityMembersInjector;
    
      private FragmentComponentImpl(FragmentModule fragmentModule) {  
        if (fragmentModule == null) {
          throw new NullPointerException();
        }
        this.fragmentModule = fragmentModule;
        initialize();
      }
    
      private void initialize() {  
        this.provideContextProvider = FragmentModule_ProvideContextFactory.create(fragmentModule);
        this.mainFragmentMembersInjector = MainFragment_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), DaggerAppComponent.this.provideContextProvider, ActivityComponentImpl.this.provideContextProvider, provideContextProvider);
        this.mainActivityMembersInjector = MainActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), DaggerAppComponent.this.provideContextProvider, ActivityComponentImpl.this.provideContextProvider, ActivityComponentImpl.this.someModelProvider);
      }
    
      @Override
      public void inject(MainFragment fragment) {  
        mainFragmentMembersInjector.injectMembers(fragment);
      }
    }
  }
}

