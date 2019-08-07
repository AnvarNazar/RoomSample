package com.seriescoding.roomsample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AddressDao {

    @Insert
    void insert(Address address);

    @Insert
    void insertAll(Address... addresses);

    @Query("SELECT * FROM address WHERE id = :id")
    Address loadById(int id);

    @Query("SELECT * FROM address WHERE id IN (:ids)")
    Address loadAllByIds(int[] ids);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Address address);

    @Delete
    void delete(Address address);
}
