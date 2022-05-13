package com.example.pa2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import java.util.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/confirmation")
public class confirmation extends HttpServlet
    {
    
        // process "get" requests from clients
        protected void doGet(HttpServletRequest request,
                HttpServletResponse response)
                throws ServletException, IOException
        {

            PrintWriter out = response.getWriter();
            response.setContentType("text/html");

            HttpSession session = request.getSession();
            HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");



            String fullname = request.getParameter("full_name");
            String phoneNum = request.getParameter("tele");
            String email = request.getParameter("email");
            String address = request.getParameter("shipper");
            String city = request.getParameter("shipper_city");
            String state = request.getParameter("shipper_state");
            String zip = request.getParameter("zipcode");
            String shipMethod = request.getParameter("opt_shipping");            
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double totalprice = Double.parseDouble(request.getParameter("totprice"));


            out.println("<html lang=\"en\"><head> <meta charset=\"UTF-8\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <link rel = \"stylesheet\" href = \"style.css\"> <link rel = \"stylesheet\" href= \"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <title>Tenzo and Richard's Store</title> <script src=\"https://code.jquery.com/jquery-3.6.0.js\"></script> <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js\"></script> <script> $(document).ready(function(){ $('#hamburger').click(function(){ $('ul').toggleClass('show'); }); });"); 
            out.println(" </script> <link rel=\"icon\" href=\"https://www.nicepng.com/png/full/96-961724_svg-transparent-download-dog-s-by-seng-hoong.png\"></head><body> <header> <nav> <img src=\"mainlogo.png\" alt=\"logo\"> <ul> <li><a href = \"home\">Home</a></li> <li><a href = \"about\">About Our Company</a></li> <li><a href = \"products\">Products</a></li> <li class = \"current\"><a href = \"checkout\">Check Out</a></li> </ul> <label id=\"hamburger\"> <i class=\"fas fa-bars\"></i> </label> </nav> </header>");
            
    
            
            out.println("<h1>Thank you for your order!</h1><br><br>");
            out.println("<h2>Your Order Details</h2><br>");
            out.println("<p1>Your Name: " + fullname + "</p1><br>");
            out.println("<p1>Your Phone Number: " + phoneNum + "</p1><br>");
            out.println("<p1>Your Email Address: " + email + "</p1><br>");
            out.println("<p1>Address:<br> " + address + "</p1><br>");
            out.println("<p1>" + city + ", " + state + " " + zip + "</p1><br>");
            out.println("<p1>Shipping: " + shipMethod + "</p1><br><br><br>");

            out.println("<h3>Your Orders: </h3><br>");

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/" + "game_db", "root", "Mal3k$aM");
            //Statement stmt = con.createStatement();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO order_details VALUES (?, ?, ?, ?, ?, ?)");

            String sql = "SELECT * FROM orders ORDER BY id DESC";

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
    
                int ordernumberInc = rs.getInt("id");






            
            for(Map.Entry<String, Integer> entry: cart.entrySet()) {
                String gameId = entry.getKey();
                String sql2 = "SELECT * FROM games WHERE id=" + gameId;
                ResultSet res = stmt.executeQuery(sql2);

                if (res.next()) {
                    out.println("<p1>Game: "+res.getString("name")+" Price: "+res.getDouble("price")+"</p1><br>");
                    stmt.setInt(1, ordernumberInc);

                    stmt.setString(2, gameId);
                    stmt.setString(3, res.getString("name"));
                    stmt.setDouble(4, res.getDouble("price"));
                    stmt.setInt(5, quantity);
                    stmt.setInt(6, 0); //rating
                    stmt.executeUpdate();
                }
            }
            }
    
    
            stmt.close();
            con.close();
    
            out.println("<h3>Total Price: " + totalprice + "</h3><br><br>");
            out.println("<h3>Total Quantity: "+quantity+"</h3>");

            request.getSession().invalidate();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
             //TODO Auto-generated catch block
            e.printStackTrace();
        }
    
        String url = "/rating";
        RequestDispatcher rd=request.getRequestDispatcher(url);
        rd.include(request, response);

        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo() {
            return "Short description";
        }// </editor-fold>
    
        
    
    }
 
