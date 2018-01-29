package com.sb.bookws.dao;

import com.sb.bookws.entity.Genre;
import java.util.ArrayList;
import java.util.List;

public class GenreDao {

    private int id = 0;
    private List<Genre> genres = new ArrayList<>();

    public int getNextId() {
        return ++id;
    }

    public int create(Genre genre) {
        if (genre.getId() <= 0) {
            genre.setId(getNextId());
        }
        if (-1 != findById(genre.getId())) {
            throw new RuntimeException("ID " + genre.getId() + " already exists");
        }
        genres.add(genre);
        return genre.getId();
    }

    public int findById(int genreid) {
        for (int i = 0; i < genres.size(); i++) {
            if (genreid == genres.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

}
