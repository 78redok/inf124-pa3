<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel = "stylesheet" href = "style.css">
    <link rel = "stylesheet" href= "https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tenzo and Richard's Store</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
    <script>
        $(document).ready(function(){
            $('#hamburger').click(function(){
                $('ul').toggleClass('show');
            });
        });
    </script>
    <link rel="icon" href="https://www.nicepng.com/png/full/96-961724_svg-transparent-download-dog-s-by-seng-hoong.png">
</head>
<body>
    <header>
        <nav>
            <img src="mainlogo.png" alt="logo">
            <ul>
                <li class = "current"><a href = "home.jsp">Home</a></li>
                <li><a href = "about.jsp">About Our Company</a></li>
                <li><a href = "products">Products</a></li>
                <li><a href = "checkout">Check Out</a></li>
            </ul>
            <label id="hamburger">
                <i class="fas fa-bars"></i>
            </label>
        </nav>
    </header>

    <section id="mainintroduction">
        <div class="about_container">
            <h1>Welcome to TR Games</h1>
            <p1>Tenzo and Richard's INF124 Homework Assignment.</p1>
        </div>
    </section>
</body>
</html>