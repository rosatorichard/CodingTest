package com.batchmates.android.codingtestpractice;

/**
 * Created by Android on 7/27/2017.
 */

public interface BasePresenter <V extends BaseView>{

    void addview(V view);

    void removeView();
}
