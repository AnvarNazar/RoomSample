package com.seriescoding.roomsample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {
        User.class,
        Address.class,
        Book.class},

        version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract AddressDao addressDao();

    public abstract BookDao bookDao();
}
