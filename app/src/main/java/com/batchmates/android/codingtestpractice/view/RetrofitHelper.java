package com.batchmates.android.codingtestpractice.view;

import com.batchmates.android.codingtestpractice.model.BookInfoPojo;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Android on 7/27/2017.
 */

public class RetrofitHelper {

    private static final String BASE_URL = "http://de-coding-test.s3.amazonaws.com/";
//books.json
    public static Retrofit Create()
    {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit;
    }

    public static Call<List<BookInfoPojo>> theBooks()
    {
        Retrofit retro=Create();
        getBooks getTheBooks=retro.create(RetrofitHelper.getBooks.class);
        return getTheBooks.getBooks();
    }


    public interface getBooks
    {
        @GET("books.json")
        Call<List<BookInfoPojo>> getBooks();
    }

}
