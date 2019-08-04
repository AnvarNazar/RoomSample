package com.seriescoding.roomsample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Address {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "pin")
    public String pin;
}
