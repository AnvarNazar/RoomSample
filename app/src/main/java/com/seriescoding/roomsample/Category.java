package com.seriescoding.roomsample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category")
public class Category {

    @PrimaryKey
    public int id;

    public String name;
}
