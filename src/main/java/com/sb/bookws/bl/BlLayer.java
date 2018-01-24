package com.sb.bookws.bl;

import com.google.gson.Gson;
import com.sb.bookws.dao.AuthorDao;
import com.sb.bookws.entity.Author;

public class BlLayer {

    AuthorDao authordao;

    public void setAuthordao(AuthorDao authordao) {
        this.authordao = authordao;
    }
        
    public String preCreateAuthor(String json){
        
        Gson gson = new Gson();
        Author author = gson.fromJson(json, Author.class);
        return "Created whith ID " + authordao.create(author);
    }
    
    public String searchAuthorById(int id){
        
        Gson gson = new Gson();        
        return gson.toJson(authordao.searchById(id));
    }
    
    public String searchAuthorByName(String name){
        
        Gson gson = new Gson();          
        return gson.toJson(authordao.findByName(name));
    }
    
    public int removeAuthor(int id){
                    
        return authordao.remove(id);
    }
    
    public void updateauthor(String json){
        
        Gson gson = new Gson(); 
        Author author = gson.fromJson(json, Author.class);
        authordao.update(author);
    }
       

}
