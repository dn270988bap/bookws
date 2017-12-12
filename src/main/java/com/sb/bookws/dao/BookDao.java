package com.sb.bookws.dao;

import com.sb.bookws.entity.Book;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private int id = 0;
    List<Book> books = new ArrayList<>();

    public void create(Book book) {
        if (book.getId() <= 0) {
            book.setId(getNextId());
        }
        books.add(book);
    }

    public void update() {

    }

    public void remove(int id) {
        if (id > 0) {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getId() == id) {
                    books.remove(i);
                }
            }
        }
    }

    public int getNextId() {
        return ++id;
    }

}
