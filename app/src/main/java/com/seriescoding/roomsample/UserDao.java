package com.seriescoding.roomsample;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface UserDao {

    @Insert
    void insert(User user);

    @Insert
    void insertAll(User... users);

    @Query("SELECT * FROM user WHERE uid = :userId")
    User loadById(int userId);

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(User user);

    @Delete
    void delete(User user);

}
