package com.sb.bookws.dao;

import com.sb.bookws.entity.Author;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

    private int id = 0;
    List<Author> authors = new ArrayList<>();

    public void create(Author author) {
        int cnt = 0;
        if (author.getId() <= 0) {
            author.setId(getNextId());
            authors.add(author);
        } else {
            for (int j = 0; j < authors.size(); j++) {
                if (author.getId() == authors.get(j).getId()) {
                    cnt++;
                }
            }
            if (cnt == 0) {
                authors.add(author);
            } else {
                author.setId(getNextId());
                authors.add(author);
            }

        }

    }

    public void update() {

    }

    public void remove(int id) {
        if (id > 0) {
            for (int i = 0; i < authors.size(); i++) {
                if (authors.get(i).getId() == id) {
                    authors.remove(i);
                }
            }
        }
    }

    public int getNextId() {
        return ++id;
    }

}
