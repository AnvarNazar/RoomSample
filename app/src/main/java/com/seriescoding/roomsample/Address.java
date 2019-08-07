package com.seriescoding.roomsample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "uid",
        childColumns = "user_id"))
public class Address {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "pin")
    public String pin;

    @ColumnInfo(name = "user_id")
    public int userId;
}
