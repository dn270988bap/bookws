package com.sb.bookws.servlet;

import com.google.gson.Gson;
import com.sb.bookws.dao.AuthorDao;
import com.sb.bookws.entity.Author;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddAuthorsServlet extends HttpServlet {

    private final AuthorDao authorDao = new AuthorDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String line = "";
        String tmp;

        BufferedReader reader = request.getReader();

        while ((tmp = reader.readLine()) != null) {
            line = line + tmp;
        }

        Gson gson = new Gson();
        Author author = gson.fromJson(line, Author.class);

        authorDao.create(author);

    }

}
