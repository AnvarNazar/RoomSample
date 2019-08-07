package com.seriescoding.roomsample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "book_category_join",
        primaryKeys = {"isbn", "category_id"},
        foreignKeys = {
                @ForeignKey(entity = Book.class,
                        parentColumns = "isbn",
                        childColumns = "book_isbn"),
                @ForeignKey(entity = Category.class,
                        parentColumns = "id",
                        childColumns = "category_id")
        })
public class BookCategoryJoin {

    @ColumnInfo(name = "book_isbn")
    @NonNull
    public String isbn;

    @ColumnInfo(name = "category_id")
    public int categoryId;
}
