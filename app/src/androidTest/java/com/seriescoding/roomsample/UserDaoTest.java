package com.seriescoding.roomsample;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(AndroidJUnit4.class)
public class UserDaoTest {

    AppDatabase db;

    @Before
    public void initDb() {
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase.class)
                .build();
    }

    @Test
    public void insertAndRead() {
        UserDao userDao = db.userDao();

        // create user
        User user = new User();
        user.uid = 101;
        user.firstName = "Kirby";
        user.lastName = "Grabowski";
        user.email = "kirbygrabowski@gmail.com";

        // insert and read user
        userDao.insert(user);
        User loaded = userDao.loadById(101);

        // verify
        assertThat(loaded, notNullValue());
        assertThat(loaded.firstName, is(user.firstName));
        assertThat(loaded.lastName, is(user.lastName));
        assertThat(loaded.email, is(user.email));
    }

    @Test
    public void createUserIfNotExists_exists() {
        UserDao userDao = db.userDao();
        // create and insert user
        User user = new User();
        user.uid = 102;
        user.firstName = "Kirby";
        user.lastName = "Grabowski";
        user.email = "kirbygrabowski@gmail.com";
        userDao.insert(user);

        // try to insert the same user again
        long inserted = userDao.insertIfNotExists(user);
        assertThat(inserted, is(-1L));
    }

    @Test
    public void createUserIfNotExists_notExits() {
        UserDao userDao = db.userDao();
        // create and insert user
        User user = new User();
        user.uid = 103;
        user.firstName = "Kirby";
        user.lastName = "Grabowski";
        user.email = "kirbygrabowski@gmail.com";

        // insert the user which does not exist
        long l = userDao.insertIfNotExists(user);
        assertThat(l, is(103L));
    }


    @After
    public void closeDb() {
        db.close();
    }
}