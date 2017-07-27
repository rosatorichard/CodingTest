package com.batchmates.android.codingtestpractice.view;

import com.batchmates.android.codingtestpractice.BasePresenter;
import com.batchmates.android.codingtestpractice.BaseView;
import com.batchmates.android.codingtestpractice.model.MyBookPojo;

import java.util.List;

/**
 * Created by Android on 7/27/2017.
 */

public interface MainActivityContract{

    interface View extends BaseView
    {
        public void populateRecycler(List<MyBookPojo> myBookPojos);
    }


    interface Presenter extends BasePresenter<View>
    {
        void BookList();

    }

}
