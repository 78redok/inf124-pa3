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



@WebServlet("/playstation")
public class playstation extends HttpServlet
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
        String sql = "SELECT * FROM games WHERE platform = 'Playstation'";
        ResultSet rs = stmt.executeQuery(sql);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // send HTML page to client
        out.println("<html lang=\"en\"><head> <meta charset=\"UTF-8\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <link rel = \"stylesheet\" href = \"style.css\"> <link rel = \"stylesheet\" href= \"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <title>Tenzo and Richard's Store</title> <script src=\"https://code.jquery.com/jquery-3.6.0.js\"></script> <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js\"></script> <script> $(document).ready(function(){ $('#hamburger').click(function(){ $('ul').toggleClass('show'); }); });"); 
        out.println(" </script> <link rel=\"icon\" href=\"https://www.nicepng.com/png/full/96-961724_svg-transparent-download-dog-s-by-seng-hoong.png\"></head><body> <header> <nav> <img src=\"mainlogo.png\" alt=\"logo\"> <ul> <li><a href = \"home\">Home</a></li> <li><a href = \"about\">About Our Company</a></li> <li class = \"current\"><a href = \"products\">Products</a></li> <li><a href = \"checkout\">Check Out</a></li> </ul> <label id=\"hamburger\"> <i class=\"fas fa-bars\"></i> </label> </nav> </header>");
        out.println("<div class=\"switchsection\">");
        out.println("<div class=\"cards\">");
        out.println("<div class=\"switch-products\">");
        out.println("<h1>Playstation 5 Products</h1></div>");
        while(rs.next()){                  
        out.println("<div class=\"card\">");
        out.println("<div class=\"image-section\">");
            int gameId = rs.getInt("id"); 
            String imglocation = rs.getString("imgSrc");
            String prodname = rs.getString("name");
            String prodPrice = rs.getString("price");
            out.println("<img src=" + imglocation + "></div>");
//<a href="#popupkart">
//<img src="./switch/kart.jpeg" alt="Mario Kart">
//</a>
            out.println("<div class=\"description\">");
//"<h1>Mario Kart</h1>
//<p><b>Price:</b><span>$49.99</span><del>$59.99</del></p></div>
            out.println("<h1>" + prodname + "</h1></div>");
            out.println("<p><b>Price: </b><span>" + prodPrice + "</span></p>");
        //out.println("<div class=\"button-group\">");
        //out.println("<a href=\"productdetails\" class=\"buy\">Product Details</a></div>");
        //out.println("</div>");

        //<form action="/action_page.php" method="get">
    //<label for="fname">First name:</label>
    //<input type="text" id="fname" name="fname"><br><br>
    //<label for="lname">Last name:</label>
    //<input type="text" id="lname" name="lname"><br><br>
     //<button type="submit">Submit</button>
     //<button type="submit" formmethod="post">Submit using POST</button>
       // </form>

       out.println("<form  action=\"productdetails\" method=\"GET\">");
       out.println("<input type=hidden id=gameId name=gameId value="+ gameId +">");
       out.println("<input type=submit value=Details>");               
       out.println("</form></div>"); 
    }}
    catch(ClassNotFoundException e){
        e.printStackTrace();
    } catch (SQLException e) {
         //TODO Auto-generated catch block
        e.printStackTrace();
    }

}
}