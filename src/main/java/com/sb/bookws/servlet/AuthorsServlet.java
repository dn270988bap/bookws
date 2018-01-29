package com.sb.bookws.servlet;

import com.sb.bookws.bl.BlLayer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorsServlet extends HttpServlet {

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

        BlLayer bl = (BlLayer) getServletContext().getAttribute("bl");

        out.println(bl.preCreateAuthor(line));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        BlLayer bl = (BlLayer) getServletContext().getAttribute("bl");

        try {
            out.println(bl.searchAuthorByName(name));
        } catch (NullPointerException ne) {
            out.println(bl.searchAuthorById(Integer.parseInt(id)));
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");

        BlLayer bl = (BlLayer) getServletContext().getAttribute("bl");

        out.println(bl.removeAuthor(Integer.parseInt(id)));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String line = "";
        String tmp;

        BufferedReader reader = request.getReader();

        while ((tmp = reader.readLine()) != null) {
            line = line + tmp;
        }

        BlLayer bl = (BlLayer) getServletContext().getAttribute("bl");
        bl.updateauthor(line);

    }

}
