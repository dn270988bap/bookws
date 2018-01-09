package com.sb.bookws.dao;

import com.sb.bookws.entity.Book;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private int id = 0;
    private List<Book> books = new ArrayList<>();

    public int getNextId() {
        return ++id;
    }

    public int create(Book book) {
        if (book.getId() <= 0) {
            book.setId(getNextId());
        }
        if (-1 != findById(book.getId())) {
            throw new RuntimeException("ID already exists");
        }

        books.add(book);
        return book.getId();
    }

    public int findById(int bookid) {
        for (int i = 0; i < books.size(); i++) {
            if (bookid == books.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

}
