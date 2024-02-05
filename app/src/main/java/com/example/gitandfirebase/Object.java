package com.example.gitandfirebase;
import android.widget.ImageView;

public class Object {
    private ImageView imageView;
    private String name;
    public Object()
    {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }
    public Object(ImageView imageView,String name)
    {
        this.imageView = imageView;
        this.name = name;
    }
}
