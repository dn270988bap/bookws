package com.sb.bookws.bl;

import com.google.gson.Gson;
import com.sb.bookws.entity.Author;
import com.sb.bookws.entity.Book;
import com.sb.bookws.entity.Genre;
import com.sb.bookws.dao.AuthorDao;
import com.sb.bookws.dao.BookDao;
import com.sb.bookws.dao.GenreDao;




public class BlLayer {

    AuthorDao authordao;
    BookDao bookdao;
    GenreDao genredao;

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

        Gson gson = new Gson();
        Author author = gson.fromJson(json, Author.class);
        return "Created whith ID " + authordao.create(author);
    }

    public String searchAuthorById(int id) {

        Gson gson = new Gson();
        return gson.toJson(authordao.searchById(id));
    }

    public String searchAuthorByName(String name) {

        Gson gson = new Gson();
        return gson.toJson(authordao.findByName(name));
    }

    public int removeAuthor(int id) {

        return authordao.remove(id);
    }

    public void updateauthor(String json) {

        Gson gson = new Gson();
        Author author = gson.fromJson(json, Author.class);
        authordao.update(author);
    }
    
    public String preCreateBook(String json) {

        Gson gson = new Gson();
        Book book = gson.fromJson(json, Book.class);
        if (-1 != authordao.findById(book.getAuthorid())){
            return "Created whith ID " + bookdao.create(book);
        }
        return "Author not found";
    }

    public String preCreateGenre(String json) {

        Gson gson = new Gson();
        Genre genre = gson.fromJson(json, Genre.class);
        return "Created whith ID " + genredao.create(genre);
    }

}
