package com.sb.bookws.dao;

import com.sb.bookws.entity.Author;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

    private int id = 0;
    private List<Author> authors = new ArrayList<>();

    public void create(Author author) {

        if (author.getId() <= 0) {
            author.setId(getNextId());
        } else if (-1 != findById(author.getId())) {
            throw new RuntimeException("ID already exists");
        }
        authors.add(author);
    }

    public void update() {

    }

    public void remove(int id) {
        if (-1 != findById(id)) {
            authors.remove(findById(id));
        }
    }

    public int findById(int authorid) {
        int pos = -1;
        for (int i = 0; i < authors.size(); i++) {
            if (authorid == authors.get(i).getId()) {
                pos = i;
            }
        }
        return pos;
    }

    public int getNextId() {
        return ++id;
    }

}
