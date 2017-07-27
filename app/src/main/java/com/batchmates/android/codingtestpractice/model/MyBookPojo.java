package com.batchmates.android.codingtestpractice.model;

/**
 * Created by Android on 7/27/2017.
 */

public class MyBookPojo {

    String image;
    String name;
    String Author;

    public MyBookPojo(String image, String name, String author) {
        this.image = image;
        this.name = name;
        Author = author;
    }


    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return Author;
    }
}
