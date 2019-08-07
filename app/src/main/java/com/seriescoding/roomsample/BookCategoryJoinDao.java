package com.seriescoding.roomsample;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookCategoryJoinDao {

    @Insert
    void insert(BookCategoryJoin bookCategoryJoin);

    @Query("SELECT * FROM book " +
            "INNER JOIN book_category_join " +
            "ON book.isbn = book_category_join.book_isbn " +
            "WHERE book_category_join.category_id = :categoryId")
    List<Book> getBooksByCategory(final int categoryId);

    @Query("SELECT * FROM category " +
            "INNER JOIN book_category_join " +
            "ON category.id = book_category_join.category_id " +
            "WHERE book_category_join.book_isbn = :isbn")
    List<Category> getCategorysByBook(final String isbn);
}
