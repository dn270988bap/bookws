package com.sb.bookws.servlet;

import com.google.gson.Gson;
import com.sb.bookws.dao.AuthorDao;
import com.sb.bookws.entity.Author;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddAuthorsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String line = "";
        String tmp;

        BufferedReader reader = request.getReader();

        while ((tmp = reader.readLine()) != null) {
            line = line + tmp;
        }

        Gson gson = new Gson();
        Author author = gson.fromJson(line, Author.class);

        AuthorDao authordao = (AuthorDao) getServletContext().getAttribute("authordao");
        out.println("Created ID " + authordao.create(author));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");

        AuthorDao authordao = (AuthorDao) getServletContext().getAttribute("authordao");
        out.println(authordao.searchById(Integer.parseInt(id)).getName());

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");

        AuthorDao authordao = (AuthorDao) getServletContext().getAttribute("authordao");
        out.println(authordao.remove(Integer.parseInt(id)));
    }
    
     @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        //PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        AuthorDao authordao = (AuthorDao) getServletContext().getAttribute("authordao");
        authordao.update(Integer.parseInt(id), name);
    }

}
