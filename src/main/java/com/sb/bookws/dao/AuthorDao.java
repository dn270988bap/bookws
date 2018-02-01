package com.sb.bookws.dao;

import com.sb.bookws.entity.Author;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthorDao {

    private static final Logger LOG = Logger.getLogger(AuthorDao.class.getName());

    private int id = 0;
    private List<Author> authors = new ArrayList<>();

    public int create(Author author) {
        if (author.getId() <= 0) {
            author.setId(getNextId());
        }
        if (-1 != findById(author.getId())) {
            throw new RuntimeException("ID " + author.getId() + " already exists");
        }
        authors.add(author);
        return author.getId();
    }

    public int getNextId() {
        return ++id;
    }

    public void update(Author author) {
        Author copyauthor = null;
        try {
            copyauthor = (Author) author.clone();
        } catch (CloneNotSupportedException ex) {
            LOG.log(Level.SEVERE, null, ex);
            //TODO:подумать над тем, что именно делать, если не поддерживается клонирование
            //но оно ведь поддерживается ))
            return;
        }

        int authorpos = findById(copyauthor.getId());
        if (-1 == authorpos) {
            return;
        }

        authors.get(authorpos).setId(copyauthor.getId());
        authors.get(authorpos).setName(copyauthor.getName());

    }

    public int remove(int id) {
        int pos = findById(id);
        if (-1 == pos) {
            return 0;
        }

        authors.remove(pos);
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

    public Author searchById(int authorid) {
        int idlist = findById(authorid);
        if (-1 != idlist) {
            try {
                return (Author) authors.get(idlist).clone();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(AuthorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Author> findByName(String name) {
        List<Author> list = new ArrayList();
        for (int i = 0; i < authors.size(); i++) {
            if (name.equals(authors.get(i).getName())) {
                try {
                    list.add((Author) authors.get(i).clone());
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(AuthorDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

}
