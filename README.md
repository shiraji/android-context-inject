# android-context-inject
Dagger2でのContextのInjectを検証します。

Sorry No English description at this moment

## 行いたいこと

ContextをApplication/Activity/Fragmentのscopeにより注入分けを行いたい。


## 問題

`Context`を返す`Provides`のメソッドが複数あるため、`ActivityModule`にinjectし、Contextを注入しようとするとコンパイルエラーになる。

```java
@Module
public class AppModule {
    private Context context;

    public AppModule(Application app) {
        context = app;
    }

    @Provides
    public Context provideContext() {
        return context;
    }
}
```

```java
@Module
public class ActivityModule {

    final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    public Context provideContext() { // ここが重複した定義になってしまう。
        return activity;
    }
}
```

## 検証

`@Named`を使ってみました。

```java
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
```

```java
public class MainActivity extends AppCompatActivity {

    @Named("applicationContext")
    @Inject
    Context applicationContext;

    @Named("activityContext")
    @Inject
    Context activityContext;

    @Inject
    SomeModel someModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApplication.getComponent(this).inject(this);

        Log.d("MainActivity", "activityContext: " + activityContext);
        Log.d("MainActivity", "applicationContext: " + applicationContext);
        Log.d("MainActivity", "-----------------------------------------");

        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);
    }
}
```

```java
public class SubActivity extends AppCompatActivity {

    @Named("applicationContext")
    @Inject
    Context applicationContext;

    @Named("activityContext")
    @Inject
    Context activityContext;

    @Inject
    SomeModel someModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApplication.getComponent(this).inject(this);

        Log.d("SubActivity", "activityContext: " + activityContext);
        Log.d("SubActivity", "applicationContext: " + applicationContext);
    }
}
```

### ログ出力

```
D/MainFragment: applicationContext: com.github.shiraji.android_context_inject.MyApplication@f0cecc2
D/MainFragment: activityContext: com.github.shiraji.android_context_inject.MainActivity@8b01ad3
D/MainFragment: fragmentContext: com.github.shiraji.android_context_inject.MainActivity@8b01ad3
D/SomeModel: applicationContext: com.github.shiraji.android_context_inject.MyApplication@f0cecc2
D/SomeModel: activityContext: com.github.shiraji.android_context_inject.MainActivity@8b01ad3
D/MainActivity: activityContext: com.github.shiraji.android_context_inject.MainActivity@8b01ad3
D/MainActivity: applicationContext: com.github.shiraji.android_context_inject.MyApplication@f0cecc2
D/MainActivity: -----------------------------------------
D/MainFragment: applicationContext: com.github.shiraji.android_context_inject.MyApplication@f0cecc2
D/MainFragment: activityContext: com.github.shiraji.android_context_inject.SubActivity@c055ec3
D/MainFragment: fragmentContext: com.github.shiraji.android_context_inject.SubActivity@c055ec3
D/SomeModel: applicationContext: com.github.shiraji.android_context_inject.MyApplication@f0cecc2
D/SomeModel: activityContext: com.github.shiraji.android_context_inject.SubActivity@c055ec3
D/SubActivity: activityContext: com.github.shiraji.android_context_inject.SubActivity@c055ec3
D/SubActivity: applicationContext: com.github.shiraji.android_context_inject.MyApplication@f0cecc2
```

### 懸念事項

* fragmentContextはいらない
* context持ち続けないかちょっと心配。(dagger2の仕様を把握していないための不安)
* contextを注入していいことあるよね？
* contextをInjectする場合、必ず`@Named`で明記する必要がある
