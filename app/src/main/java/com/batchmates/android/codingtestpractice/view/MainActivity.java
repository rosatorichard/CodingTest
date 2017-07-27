package com.batchmates.android.codingtestpractice.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.batchmates.android.codingtestpractice.R;
import com.batchmates.android.codingtestpractice.injection.DaggerMainActivityComponent;
import com.batchmates.android.codingtestpractice.model.MyBookPojo;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    @Inject MainActivityPresenter presenter;

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private DefaultItemAnimator itemAnimator=new DefaultItemAnimator();
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.rvRecyclerView);

        setUpDagger();

        presenter.addview(this);
        presenter.BookList();
    }

    private void setUpDagger() {
        DaggerMainActivityComponent.create().inject(this);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void populateRecycler(List<MyBookPojo> myBookPojos) {

        layoutManager= new LinearLayoutManager(this);
        recyclerViewAdapter=new RecyclerViewAdapter(myBookPojos);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
