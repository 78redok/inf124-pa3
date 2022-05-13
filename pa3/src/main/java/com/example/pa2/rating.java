package com.example.pa2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;



@WebServlet("/rating")
public class rating extends HttpServlet
{
    // process "get" requests from clients
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/" + "game_db", "root", "Mal3k$aM");
            Statement stmt = con.createStatement();
            
            
            String sql = "SELECT * FROM order_details ORDER BY order_id DESC LIMIT 5";


            ResultSet rs = stmt.executeQuery(sql);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<div class=\"button-group\"><a href=\"#popupfive\" class=\"buy\">Last 5 Orders</a></div>");

            out.println("<div class=\"overlay\" id=\"popupfive\">" +
            "<div class=\"wrapper\">" +
            "<h2 id=\"productNameelden\">Last 5 Orders</h2>" +
            "<br>");
            out.println("<br>" +
            "<a href=\"#\" class=\"close\">&times;</a>" +
            "<div class=\"content\">" +
            "<div class=\"container\"></id>");

            int orders = 1;
            
            while(rs.next()){
            
            out.println("<h1 style=\"text-align:center;\">Order " + orders + "</h1>");
            String game_name = rs.getString("game_name");
            Double price = rs.getDouble("price");
            //int quantity = rs.getInt("quantity");
            int rating = rs.getInt("rating");
            out.println("<br>");
            out.println("<p style=\"text-align:center;\"><b>Game Name: </b>" + game_name + "</p>");
            out.println("<p style=\"text-align:center;\"><b>Price: </b>" + price + "</p>");
            //out.println("<p><b>Quantity: </b>" + quantity + "</p>");
            //out.println("<p style=\"text-align:center;\"><b>Rating: </b>" + rating + "</p>");

            //out.println("<script src=\"https://kit.fontawesome.com/7f00aa3f32.js\" crossorigin=\"anonymous\"></script>");

            // out.println("<center>");

            // for (int i = 0; i < rating; i++) {
            //     out.println("<i class='fa-solid fa-star'></i>");
            // }

            // for (int i = 0; i< 5 - rating; i++) {
            //     out.println("<i class='fa-regular fa-star'></i>");
            // }

            // out.println("</center>");

            orders++;

            out.println("<br><br>");

            }

            out.println("<h2 id=\"productNameelden\">Your Order Experience</h2>" +
            "<br></br>");
            String sql2 = "SELECT * FROM orders ORDER BY id DESC LIMIT 1";
            ResultSet res = stmt.executeQuery(sql2);

            if (res.next()) {
                out.println("<script src=\"https://kit.fontawesome.com/7f00aa3f32.js\" crossorigin=\"anonymous\"></script>");

                out.println("<center>");
    
                for (int i = 0; i < res.getInt("ratings"); i++) {
                    out.println("<i class='fa-solid fa-star'></i>");
                }
    
                for (int i = 0; i< 5 - res.getInt("ratings"); i++) {
                    out.println("<i class='fa-regular fa-star'></i>");
                }
    
                out.println("</center>");
            }
            

        out.println("<br><br></div></div></div></div>");



    }
        
        catch(ClassNotFoundException e){
        e.printStackTrace(); 
        } 

        catch (SQLException e) {
            //TODO Auto-generated catch block
        e.printStackTrace();
        }
}
}






