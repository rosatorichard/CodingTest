package com.batchmates.android.codingtestpractice.injection;

import com.batchmates.android.codingtestpractice.view.MainActivity;

import dagger.Component;

/**
 * Created by Android on 7/27/2017.
 */
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
