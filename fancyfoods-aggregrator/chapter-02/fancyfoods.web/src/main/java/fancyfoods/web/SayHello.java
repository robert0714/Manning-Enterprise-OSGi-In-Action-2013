package fancyfoods.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class SayHello extends HttpServlet {

    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                         throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.append("Hello valued customer!");
    }

}
