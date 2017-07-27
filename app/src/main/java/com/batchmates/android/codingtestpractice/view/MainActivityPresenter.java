package com.batchmates.android.codingtestpractice.view;

import android.util.Log;

import com.batchmates.android.codingtestpractice.BaseView;
import com.batchmates.android.codingtestpractice.model.BookInfoPojo;
import com.batchmates.android.codingtestpractice.model.MyBookPojo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Android on 7/27/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter{

    private static final String TAG = "MainActivityPresenter";
    private List<MyBookPojo> bookArray=new ArrayList<>();
    MainActivityContract.View view;

    @Override
    public void addview(MainActivityContract.View view) {
        this.view=view;
    }

    @Override
    public void removeView() {

    }

    @Override
    public void BookList() {

        final retrofit2.Call<List<BookInfoPojo>> theBooks=RetrofitHelper.theBooks();
        theBooks.enqueue(new Callback<List<BookInfoPojo>>() {
            @Override
            public void onResponse(Call<List<BookInfoPojo>> call, Response<List<BookInfoPojo>> response) {
                for (int i = 0; i <response.body().size() ; i++) {
                    bookArray.add(new MyBookPojo(response.body().get(i).getImageURL(),
                            response.body().get(i).getTitle(),
                            response.body().get(i).getAuthor()));
                }
                view.populateRecycler(bookArray);
            }

            @Override
            public void onFailure(Call<List<BookInfoPojo>> call, Throwable t) {

            }
        });
    }
}
