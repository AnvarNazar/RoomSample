package com.seriescoding.roomsample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface BookDao {

    @Insert
    void insert(Book book);

    @Insert
    void insertAll(Book... books);

    @Query("SELECT * FROM book WHERE isbn = :isbn")
    Book loadByIsbn(String isbn);

    @Query("SELECT * FROM book WHERE isbn IN (:isbns)")
    Book loadAllByIsbn(String isbns);

    @Update
    void update(Book book);

    @Delete
    void delete(Book delete);
}
