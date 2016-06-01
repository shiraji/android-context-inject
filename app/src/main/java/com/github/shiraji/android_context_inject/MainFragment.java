package com.github.shiraji.android_context_inject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;
import javax.inject.Named;

public class MainFragment extends Fragment {

    @Named("applicationContext")
    @Inject
    Context applicationContext;

    @Named("activityContext")
    @Inject
    Context activityContext;

    @Named("fragmentContext")
    @Inject
    Context fragmentContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent(this).inject(this);

        Log.d("MainFragment", "applicationContext: " + applicationContext);
        Log.d("MainFragment", "activityContext: " + activityContext);
        Log.d("MainFragment", "fragmentContext: " + fragmentContext);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, container, false);
    }
}
