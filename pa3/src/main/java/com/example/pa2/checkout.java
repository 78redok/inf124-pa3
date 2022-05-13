package com.example.pa2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import java.util.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;



@WebServlet("/checkout")
public class checkout extends HttpServlet
{
    

    // process "get" requests from clients
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html;charset=UTF-8");
        String gameId = request.getParameter("gameId");

        HttpSession session = request.getSession(true);
        HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<String, Integer>();
            cart.put(gameId, 1);
        } else             {
            Integer quantity = cart.get(gameId);

            if(quantity == null)
                cart.put(gameId, 1);
            else
                cart.put(gameId, ++quantity);
        }

        session.setAttribute("cart", cart);

        PrintWriter out = response.getWriter();


        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/" + "game_db", "root", "Mal3k$aM");
            Statement stmt = con.createStatement();
            double totalprice = 0;
            int qty = 0;
            out.println("<html lang=\"en\"><head> <meta charset=\"UTF-8\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> <link rel = \"stylesheet\" href = \"style.css\"> <link rel = \"stylesheet\" href= \"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\"><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"/><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <title>Tenzo and Richard's Store</title> <script src=\"https://code.jquery.com/jquery-3.6.0.js\"></script> <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js\"></script> <script> $(document).ready(function(){ $('#hamburger').click(function(){ $('ul').toggleClass('show'); }); });"); 
            
            out.println("function myFunction(zipcode, name, creditname, creditnumber, creditmonth, credityear) {" +
                "let a = zipcode.toString().length;" +
                "if(a != 5) {" +
                    "alert(\"Zip Code Must Be 5 Digits.\");" +
                    "return false;}" +
                "var regex = /^[a-zA-Z]+ [a-zA-Z]+$/;" +
                "var b = name;" +
                "if(!regex.test(name)){" +
                   
                    "alert('Invalid Name Given(No Spaces After Last Name).');" +
                    "return false;}" +
                "if(!regex.test(creditname)){" +
                   
                    "alert('Invalid Credit Card Name Given(No Spaces After Last Name).');" +
                    "return false;}" +
                "var cardno = /^(?:4[0-9]{12}(?:[0-9]{3})?)$/;" +
                "if(!creditnumber.value.match(cardno)){" +
                
                "alert('Not a Valid Credit Card Number(Must Start w/ 4(Visa Only) and 13/16 Digits)');" +
                "return false;}" +
                "var cardmonth = /^[0-9]{2}$/;" + 
                "if(!creditmonth.value.match(cardmonth)){" +
                
                "alert('Credit Card Month Must Be 2 Digits.');" +
                "return false;}" +
                "var credyear = /^[0-9]{4}$/;" +
                "if(!credityear.value.match(credyear)){" +
                
                "alert('Credit Card Year Must Be 4 Digits.');" +
                "return false;}" +

                "}");
            
            out.println(" </script> <link rel=\"icon\" href=\"https://www.nicepng.com/png/full/96-961724_svg-transparent-download-dog-s-by-seng-hoong.png\"></head><body> <header> <nav> <img src=\"mainlogo.png\" alt=\"logo\"> <ul> <li><a href = \"home\">Home</a></li> <li><a href = \"about\">About Our Company</a></li> <li><a href = \"products\">Products</a></li> <li class = \"current\"><a href = \"checkout\">Check Out</a></li> </ul> <label id=\"hamburger\"> <i class=\"fas fa-bars\"></i> </label> </nav> </header>");
            out.println("<div class=\"switchsection\">");
            out.println("<div class=\"cards\">");
            out.println("<div class=\"switch-products\">");
            out.println("<h1>Cart Items</h1></div>");
            out.println("<div class=\"card\">");
            out.println("<div class=\"image-section\">");

            for (String gameID : cart.keySet()) {
                String sql = "SELECT * FROM games WHERE id =" + gameID;
                ResultSet rs = stmt.executeQuery(sql);


                while (rs.next()) {
                totalprice += rs.getDouble("price");
                qty++;
                out.println("<table> <tr> <td>"+rs.getString("name")+"</td> <td style=\"text-align:right\">"+ rs.getDouble("price")+"</td> </tr></table>");
                
                }
            }
            out.println("<p1>" + totalprice + "</p1>");

            out.println("<div class=\"overlay\" id=\"popupform\">" +
            "<div class=\"wrapper\">" +
                "<h2 id=\"productNameelden\">Check Out Form</h2>" +
                "<br></br>");
            out.println("<p1>Your items:</p1><br>");

                for (String gameID : cart.keySet()) {
                    String sql = "SELECT * FROM games WHERE id =" + gameID;
                    ResultSet rs = stmt.executeQuery(sql);
    
    
                    while (rs.next()) {
                        out.println("<p1>" + rs.getString("name") + " Price: " + rs.getDouble("price") + "<br>");

                    }
                }

            out.println("<p>Total Price:"+totalprice+" </p> " + 
            "<br /> " + 
            "<a href='#' class='close'>&times;</a> " + 
            "<div class='content'> " + 
            "  <div class='container'> " + 
            "    <form " + 
            "      id='myForm' " + 
            "      name='formform' " + 
            "      onsubmit=\"return myFunction(document.getElementById('zipcode').value, document.getElementById('name').value, document.getElementById('credit_name2').value, document.formform.credit_num, document.formform.credit_month, document.formform.credit_year)\"" + 
            "      action='submitform' " + 
            "      method='GET' " + 
            "    > " + 
            "      <input type='hidden' name='quantity' value="+qty+" /> " + 
            "      <input type='hidden' name='totprice' value="+totalprice+" /> " + 
            "      <label>Full Name</label> " + 
            "      <input " + 
            "        type='text' " + 
            "        name='full_name' " + 
            "        id='name' " + 
            "        placeholder='Your Full Name' " + 
            "        required " + 
            "      /> " + 
            "      <label>Phone Number</label> " + 
            "      <input " + 
            "        type='text' " + 
            "        name='tele' " + 
            "        id='tele' " + 
            "        placeholder='Phone Number' " + 
            "        required " + 
            "      /> " + 
            "      <label>Shipping Address</label> " + 
            "      <input " + 
            "        type='text' " + 
            "        name='shipper' " + 
            "        id='address' " + 
            "        placeholder='Address' " + 
            "        required " + 
            "      /> " + 
            "      <label>Shipping City</label> " + 
            "      <input " + 
            "        type='text' " + 
            "        name='shipper_city' " + 
            "        placeholder='Address City' " + 
            "        required " + 
            "      /> " + 
            "      <label>Shipping State</label> " + 
            "      <input " + 
            "        type='text' " + 
            "        name='shipper_state' " + 
            "        placeholder='Address State' " + 
            "        required " + 
            "      /> " + 
            "      <label>Zip Code</label> " + 
            "      <input " + 
            "        type='text' " + 
            "        name='zipcode' " + 
            "        placeholder='Zip Code' " + 
            "        id='zipcode' " + 
            "        required " + 
            "      /> " + 
            "      <label>E-Mail Address</label> " + 
            "      <input " + 
            "        type='email' " + 
            "        name='email' " + 
            "        id='email' " + 
            "        placeholder='Email Address' " + 
            "        required " + 
            "      /> " + 
            "      <label>Credit Card Name</label> " + 
            "      <input " + 
            "        type='text' " + 
            "        name='credit_name' " + 
            "        id='credit_name2' " + 
            "        placeholder='Credit Card Name' " + 
            "        required " + 
            "      /> " + 
            "      <label>Card Number</label> " + 
            "      <input " + 
            "        type='text' " + 
            "        name='credit_num' " + 
            "        id='credit_num2' " + 
            "        placeholder='Credit Card Number' " + 
            "        required " + 
            "      /> " + 
            "      <label>Expiration Month</label> " + 
            "      <input " + 
            "        type='number' " + 
            "        name='credit_month' " + 
            "        placeholder='Expiration Month' " + 
            "        required " + 
            "      /> " + 
            "      <label>Expiration Year</label> " + 
            "      <input " + 
            "        type='number' " + 
            "        name='credit_year' " + 
            "        placeholder='Expiration Year' " + 
            "        required " + 
            "      /> " + 
            "      <label>Shipping Options</label><br /><br /> " + 
            "      <input " + 
            "        type='radio' " + 
            "        id='Expedited' " + 
            "        name='opt_shipping' " + 
            "        value='Expedited Shipping' " + 
            "        required " + 
            "      /> " + 
            "      <label for='Expedited'>Expedited Shipping (1-3 days)</label><br /> " + 
            "      <input " + 
            "        type='radio' " + 
            "        id='Standard' " + 
            "        name='opt_shipping' " + 
            "        value='Standard Shipping' " + 
            "      /> " + 
            "      <label for='Standard'>Standard Shipping (5-7 days)</label> " + 
            "      <br /><br /><br /> " + 
            "      <p>Review Your Experience</p> " + 
            "      <div class='container_rating'> " + 
            "        <div class='star-widget'> " + 
            "          <input type='radio' name='rate' id='rate-5' value='5' /> " + 
            "          <label for='rate-5' class='star'><i class='fa fa-star'></i></label> " + 
            "          <input type='radio' name='rate' id='rate-4' value='4' /> " + 
            "          <label for='rate-4' class='star'><i class='fa fa-star'></i></label> " + 
            "          <input type='radio' name='rate' id='rate-3' value='3' /> " + 
            "          <label for='rate-3' class='star'><i class='fa fa-star'></i></label> " + 
            "          <input type='radio' name='rate' id='rate-2' value='2' /> " + 
            "          <label for='rate-2' class='star'><i class='fa fa-star'></i></label> " + 
            "          <input type='radio' name='rate' id='rate-1' value='1' /> " + 
            "          <label for='rate-1' class='star'><i class='fa fa-star'></i></label> " + 
            "          <br /><br /> " + 
            "          <br /><br /> " + 
            "        </div> " + 
            "      </div> " + 
            "       <br /><br /> " + 
            "      <input type='submit' value='Submit' /> " + 
            "    </form> " + 
            "  </div> " + 
            "</div></div></div>" );

                        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
             //TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        out.println("<div class=\"button-group\"><a href=\"#popupform\" class=\"buy\">Review and Check Out</a></div>");

 
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
