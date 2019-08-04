package com.seriescoding.roomsample;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "book")
public class Book {

    @PrimaryKey
    @NonNull
    public String isbn;

    public String title;

    public String description;

    public String author;

    @Ignore
    public String ignored;
}
