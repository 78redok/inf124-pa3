package com.example.pa2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/products")
public class products extends HttpServlet
{
    // process "get" requests from clients
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // send HTML page to client
        out.println("<html lang=\"en\"><head> <meta charset=\"UTF-8\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <link rel = \"stylesheet\" href = \"style.css\" type=\"text/css\"> <link rel = \"stylesheet\" href= \"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\" type=\"text/css\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <title>Tenzo and Richard's Store</title> <script src=\"https://code.jquery.com/jquery-3.6.0.js\"></script> <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js\"></script> <script> $(document).ready(function(){ $(\'#hamburger\').click(function(){ $(\'ul\').toggleClass(\'show\'); }); }); </script> <link rel=\"icon\" href=\"https://www.nicepng.com/png/full/96-961724_svg-transparent-download-dog-s-by-seng-hoong.png\"></head><body> <header> <nav> <img src=\"mainlogo.png\" alt=\"logo\"> <ul> <li><a href = \"home\">Home</a></li> <li><a href = \"about\">About Our Company</a></li> <li class = \"current\"><a href = \"products\">Products</a></li> <li><a href = \"checkout\">Check Out</a></li> </ul> <label id=\"hamburger\"> <i class=\"fas fa-bars\"></i> </label> </nav> </header>");
        out.println("<div id=\"productcontainer\">");
        out.println("<div class=\"product-cat\">");
        out.println("<a href = \"nswitch\">");
        out.println("<img src=\"nintendo.png\" class=\"col-1\" alt=\"Nintendo Switch\"></a></div>");
        out.println("<div class=\"product-cat\">");
        out.println("<a href = \"playstation\">");
        out.println("<img src=\"playstation.png\" class=\"col-1\" alt=\"Playstation 5\"></a></div>");
        out.println("<div class=\"product-cat\">");
        out.println("<a href = \"xbox\">");
        out.println("<img src=\"xbox.png\" class=\"col-1\" alt=\"Microsoft Xbox\"></a></div>");
        out.println("<div class=\"product-cat\">");
        out.println("<a href = \"windows\">");
        out.println("<img src=\"windows.png\" class=\"col-1\" alt=\"PC Gaming\"></a></div></div></body></html>");    
    
    }
}