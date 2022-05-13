package com.example.pa2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;



@WebServlet("/productdetails")
public class productdetails extends HttpServlet
{
    

    // process "get" requests from clients
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        String gameId = request.getParameter("gameId");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");




    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/" + "game_db", "root", "Mal3k$aM");
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM games WHERE id =" + gameId;
        ResultSet rs = stmt.executeQuery(sql);

        out.println("<html lang=\"en\"><head> <meta charset=\"UTF-8\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <link rel = \"stylesheet\" href = \"style.css\"> <link rel = \"stylesheet\" href= \"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <title>Tenzo and Richard's Store</title> <script src=\"https://code.jquery.com/jquery-3.6.0.js\"></script> <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js\"></script> <script> $(document).ready(function(){ $('#hamburger').click(function(){ $('ul').toggleClass('show'); }); });"); 
        out.println(" </script> <link rel=\"icon\" href=\"https://www.nicepng.com/png/full/96-961724_svg-transparent-download-dog-s-by-seng-hoong.png\"></head><body> <header> <nav> <img src=\"mainlogo.png\" alt=\"logo\"> <ul> <li><a href = \"home\">Home</a></li> <li><a href = \"about\">About Our Company</a></li> <li class = \"current\"><a href = \"products\">Products</a></li> <li><a href = \"checkout\">Check Out</a></li> </ul> <label id=\"hamburger\"> <i class=\"fas fa-bars\"></i> </label> </nav> </header>");
        out.println("<div class=\"switchsection\">");
        out.println("<div class=\"cards\">");
        out.println("<div class=\"switch-products\">");
        out.println("<h1>Product Details</h1></div>");
        out.println("<div class=\"card\">");
        out.println("<div class=\"image-section\">");
        

        if (rs.next())
        {


           String name = rs.getString("name"); 
           String descript = rs.getString("descr1");
           String gamePrice = rs.getString("price");
           String imgLocation = rs.getString("imgSrc");

           out.println("<img src=" + imgLocation + "></div>");
           out.println("<div class=\"description\">");

           out.println("<h3>" +  name + "</h3></div>");
           out.println("<p2>" +  gamePrice + "</p2>");
           out.println("<p1>" +  descript + "</p1>");


        }

        out.println("<form  action=\"checkout\" method=\"GET\" id = \"buyform\">");
        out.println("<input type=hidden id=gameId name=gameId value="+ gameId +">");
        out.println("<input type=submit value=Add to Cart>");
        //out.println("<div class='button-group'><a href=\"checkout\" class = 'buy' value=" + gameId +">Add to Cart</button></div></div>");
        out.println("</form></div>"); 


    }
    catch(ClassNotFoundException e){
        e.printStackTrace();
    } catch (SQLException e) {
         //TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}