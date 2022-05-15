<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <link rel = "stylesheet" href = "style.css">
      <link rel = "stylesheet" href= "https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Tenzo and Richard's Store</title>
      <script src="https://code.jquery.com/jquery-3.6.0.js"></script> <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script> <script> $(document).ready(function(){ $('#hamburger').click(function(){ $('ul').toggleClass('show'); }); });
      </script> 
<link rel="icon" href="https://www.nicepng.com/png/full/96-961724_svg-transparent-download-dog-s-by-seng-hoong.png">
</head>
<body>
   <header>
      <nav>
         <img src="mainlogo.png" alt="logo"> 
         <ul>
            <li><a href = "home.jsp">Home</a></li>
            <li><a href = "about.jsp">About Our Company</a></li>
            <li class = "current"><a href = "products">Products</a></li>
            <li><a href = "checkout">Check Out</a></li>
         </ul>
         <label id="hamburger"> <i class="fas fa-bars"></i> </label> 
      </nav>
    <sql:setDataSource var = "snapshot" driver = "com.mysql.cj.jdbc.Driver"
                       url = "jdbc:mysql:// localhost:3306/game_db"
                       user = "root"  password = "Mal3k$aM"/>
    <sql:query dataSource = "${snapshot}" var = "result">
        SELECT * FROM games WHERE platform = 'PlayStation';
    </sql:query>
   </header>
<div class="switchsection">
<div class="cards">
<div class="switch-products">
<h1>Nintendo Switch Products</h1></div>
<c:forEach var = "row" items = "${result.rows}">
        <div class="card">
        <div class="image-section">
            <img src="${row.imgSrc}">
            <h1>${row.name}</h1></div>
            <p><b>Price: </b><span>${row.price}</span></p>
            <form  action="productdetails" method="GET">
            <input type=hidden id=gameId name=gameId value=${row.id}>
            <input type=submit value=Details>
            </form>
        </div>
</c:forEach>
</div>
</div>
</body>
</html>