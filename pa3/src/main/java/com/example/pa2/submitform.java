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



@WebServlet("/submitform")
public class submitform extends HttpServlet
{
    

    // process "get" requests from clients
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {


        int rate = Integer.parseInt(request.getParameter("rate"));
        String fullname = request.getParameter("full_name");
        String phoneNum = request.getParameter("tele");
        String email = request.getParameter("email");
        String address = request.getParameter("shipper");
        String city = request.getParameter("shipper_city");
        String state = request.getParameter("shipper_state");
        String zip = request.getParameter("zipcode");
        String creditName = request.getParameter("credit_name");
        String creditNum = request.getParameter("credit_num");
        String expMonth = request.getParameter("credit_month");
        String expYear = request.getParameter("credit_year");
        String shipMethod = request.getParameter("opt_shipping");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");


    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/" + "game_db", "root", "Mal3k$aM");
        //Statement stmt = con.createStatement();
        PreparedStatement stmt = con.prepareStatement("INSERT INTO orders (id, full_name, phone_number, email, addr, city, user_state, zip, c_name, c_card, exp_month, exp_year, shipping_method, ratings) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");


        ResultSet rs = stmt.executeQuery("SELECT * FROM orders ORDER BY id DESC");

        if (rs.next()) {

            int ordernumberInc = rs.getInt("id");            
            ordernumberInc++;
        
        stmt.setInt(1, ordernumberInc++);
        stmt.setString(2, fullname);
        stmt.setString(3, phoneNum);
        stmt.setString(4, email);
        stmt.setString(5, address);
        stmt.setString(6, city);
        stmt.setString(7, state);
        stmt.setString(8, zip);
        stmt.setString(9, creditName);
        stmt.setString(10, creditNum);
        stmt.setString(11, expMonth);
        stmt.setString(12, expYear);
        stmt.setString(13, shipMethod);
        stmt.setInt(14, rate);

        }

        stmt.executeUpdate();

        stmt.close();
        con.close();

    }
    catch(ClassNotFoundException e){
        e.printStackTrace();
    } catch (SQLException e) {
         //TODO Auto-generated catch block
        e.printStackTrace();
    }

    String url = "/confirmation";
    RequestDispatcher rd = request.getRequestDispatcher(url);
    rd.forward(request, response);

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
