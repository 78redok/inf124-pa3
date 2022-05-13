package com.example.pa2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/about")
public class about extends HttpServlet
{
    // process "get" requests from clients
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // send HTML page to client
        out.println("<html lang=\"en\"><head> <meta charset=\"UTF-8\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <link rel = \"stylesheet\" href = \"style.css\" type=\"text/css\"> <link rel = \"stylesheet\" href= \"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\" type=\"text/css\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <title>Tenzo and Richard's Store</title> <script src=\"https://code.jquery.com/jquery-3.6.0.js\"></script> <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js\"></script> <script> $(document).ready(function(){ $(\'#hamburger\').click(function(){ $(\'ul\').toggleClass(\'show\'); }); }); </script> <link rel=\"icon\" href=\"https://www.nicepng.com/png/full/96-961724_svg-transparent-download-dog-s-by-seng-hoong.png\"></head><body> <header> <nav> <img src=\"mainlogo.png\" alt=\"logo\"> <ul> <li><a href = \"home\">Home</a></li> <li class = \"current\"><a href = \"about\">About Our Company</a></li> <li><a href = \"products\">Products</a></li> <li><a href = \"checkout\">Check Out</a></li> </ul> <label id=\"hamburger\"> <i class=\"fas fa-bars\"></i> </label> </nav> </header>");
        out.println("<div class=\"about-section\"> <h1>About Our Company</h1> <br></br> <p>Tenzo and Richard started this company with hopes to pass IN4MTX 124's first assignment.</p> <br></br> <p>Born from a deep love for all kinds of games (with a special emphasis for JRPGs), our wish is to spread the enjoyment of games to as many as possible.</p> <p>Forget those monthly Netflix subscriptions, a fantastic game will last you hours on end with far more fulfillment than expected!</p></div>");
        out.println("<center><br></br><h2 style=\"text-align:center\">Our Team</h2><h3 style=\"text-align:center\">Programming Group 38</h3><br></br><div class=\"row\"> <div class=\"column\"> <div class=\"cardsss\"> <div text-align:center><img src=\"aesongyi.png\" alt=\"Richard\" style=\"width: 50%\"></div> <div class=\"container\"> <h2>Richard Ko</h2> <p class=\"title\">Student</p> <br></br> <p>Probably going to be moneyless.</p> <p>kor2@uci.edu</p> </div> </div> </div> <div class=\"column\"> <div class=\"cardsss\"> <div text-align:center><img src=\"nanba.jpg\" alt=\"Tenzo\" style=\"width:46.6%\"></div> <div class=\"container\"> <h2>Tenzo Chang</h2> <p class=\"title\">Student</p> <br></br> <p>Probably going to be homeless.</p> <p>tenzosc@uci.edu</p> </div> </div> </div></center></body></html>");
    }
}