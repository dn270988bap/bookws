package com.sb.bookws.dao;

import com.sb.bookws.entity.Author;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

    private int id = 0;
    private List<Author> authors = new ArrayList<>();

    public int create(Author author) {
        if (author.getId() <= 0) {
            author.setId(getNextId());
        }
        if (-1 != findById(author.getId())) {
            throw new RuntimeException("ID already exists");
        }
        authors.add(author);
        return author.getId();
    }

    public void update() {

    }

    public int remove(int id) {
        int pos = findById(id);
        if (-1 != pos) {
            authors.remove(pos);
        }
        return 1;
    }

    public int findById(int authorid) {
        for (int i = 0; i < authors.size(); i++) {
            if (authorid == authors.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public int getNextId() {
        return ++id;
    }

}
