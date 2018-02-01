package com.sb.bookws.bl;

import com.google.gson.Gson;
import com.sb.bookws.entity.Author;
import com.sb.bookws.entity.Book;
import com.sb.bookws.entity.Genre;
import com.sb.bookws.dao.AuthorDao;
import com.sb.bookws.dao.BookDao;
import com.sb.bookws.dao.GenreDao;

public class BlLayer {

    private AuthorDao authordao;
    private BookDao bookdao;
    private GenreDao genredao;
    private Gson gson = new Gson();

    public void setAuthordao(AuthorDao authordao) {
        this.authordao = authordao;
    }

    public void setBookdao(BookDao bookdao) {
        this.bookdao = bookdao;
    }

    public void setGenredao(GenreDao genredao) {
        this.genredao = genredao;
    }

    public String preCreateAuthor(String json) {

        Author author = gson.fromJson(json, Author.class);
        return "Created whith ID " + authordao.create(author);
    }

    public String searchAuthorById(int id) {
        return gson.toJson(authordao.searchById(id));
    }

    public String searchAuthorByName(String name) {
        return gson.toJson(authordao.findByName(name));
    }

    public int removeAuthor(int id) {
        return authordao.remove(id);
    }

    public void updateauthor(String json) {
        Author author = gson.fromJson(json, Author.class);
        authordao.update(author);
    }

    public String preCreateBook(String json) {
        Book book = gson.fromJson(json, Book.class);

        if (-1 == authordao.findById(book.getAuthorid())) {
            throw new RuntimeException("Author not found");
        }

        if (-1 == genredao.findById(book.getGenreid())) {
            throw new RuntimeException("Genre not found");
        }

        return "Created whith ID " + bookdao.create(book);

    }

    public String preCreateGenre(String json) {
        Genre genre = gson.fromJson(json, Genre.class);
        return "Created whith ID " + genredao.create(genre);
    }

    public int removeGenre(int id) {
        return genredao.remove(id);
    }

}
