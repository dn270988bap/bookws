package com.sb.bookws.dao;

import com.sb.bookws.entity.Author;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthorDao {

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

    public void update(int id, String name) {
        int listid = findById(id);
        if (-1 != listid){
            try {
                Author clone = authors.get(listid).clone();
                clone.setName(name);
                authors.get(listid).setName(clone.getName());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(AuthorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public int remove(int id) {
        int pos = findById(id);
        if (-1 != pos) {
            authors.remove(pos);
            return 1;
        }
        return 0;
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
            return authors.get(idlist);
        }
        return null;
    }

    public List<Author> findByName(String name) {
        List<Author> list = new ArrayList();
        for (int i = 0; i < authors.size(); i++) {
            if (name.equals(authors.get(i).getName())) {
                list.add(authors.get(i));
            }
        }
        return list;
    }

    public List<String> getAll() {
        List<String> list = new ArrayList();
        for (int i = 0; i < authors.size(); i++) {
            list.add(authors.get(i).getId() + "; " + authors.get(i).getName());
        }
        return list;
    }

}
