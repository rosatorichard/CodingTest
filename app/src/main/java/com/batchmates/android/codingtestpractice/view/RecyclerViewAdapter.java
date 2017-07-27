package com.batchmates.android.codingtestpractice.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.batchmates.android.codingtestpractice.R;
import com.batchmates.android.codingtestpractice.model.BookInfoPojo;
import com.batchmates.android.codingtestpractice.model.MyBookPojo;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 7/27/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<MyBookPojo> bookInfoPojos=new ArrayList<>();

    public RecyclerViewAdapter(List<MyBookPojo> bookInfoPojos) {
        this.bookInfoPojos = bookInfoPojos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.boook_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyBookPojo currentBook=bookInfoPojos.get(position);

        Glide.with(holder.itemView.getContext()).load(currentBook.getImage()).into(holder.bookImage);
        holder.bookName.setText(currentBook.getName());
        holder.author.setText(currentBook.getAuthor());
    }

    @Override
    public int getItemCount() {
        return bookInfoPojos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bookImage;
        TextView bookName;
        TextView author;
        public ViewHolder(View itemView) {
            super(itemView);

            bookImage=(ImageView)itemView.findViewById(R.id.ivBookImage);
            bookName=itemView.findViewById(R.id.tvBookName);
            author=itemView.findViewById(R.id.tvDiscription);
        }
    }
}
