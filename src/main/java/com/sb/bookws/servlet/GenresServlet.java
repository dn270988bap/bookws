package com.sb.bookws.servlet;

import com.sb.bookws.bl.BlLayer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GenresServlet extends HttpServlet {

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

        out.println(bl.preCreateGenre(line));

    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");

        BlLayer bl = (BlLayer) getServletContext().getAttribute("bl");

        out.println(bl.removeGenre(Integer.parseInt(id)));
    }
}
