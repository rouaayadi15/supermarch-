<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Supermarché</title>

    <!-- ICONS -->
    <link rel="stylesheet"
     href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <style>
        body {
            margin: 0;
            font-family: Arial;
            background: #f5f5f5;
            text-align: center;
        }

        /* NAVBAR */
        .navbar {
            background: #2ecc71;
            padding: 15px;
            color: white;
            font-size: 20px;
        }

        .navbar a {
            color: white;
            margin: 10px;
            text-decoration: none;
            font-weight: bold;
        }

        .navbar a:hover {
            text-decoration: underline;
        }

        /* TITLE */
        h1 {
            margin-top: 30px;
        }

        /* CARDS */
        .container {
            margin-top: 40px;
        }

        .card {
            display: inline-block;
            background: white;
            width: 250px;
            margin: 20px;
            padding: 20px;
            border-radius: 15px;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.2);
            transition: 0.3s;
        }

        .card:hover {
            transform: scale(1.05);
        }

        .card img {
            width: 150px;
        }

        .card h3 {
            margin-top: 10px;
        }

        .card a {
            text-decoration: none;
            color: black;
        }

    </style>
</head>

<body>

<!-- NAVBAR -->
<div class="navbar">
    🛒 Supermarché |
    <a href="panier"><i class="fa fa-shopping-cart"></i> Panier</a>
    <a href="register.jsp"><i class="fa fa-user"></i> Inscription</a>
    <a href="login.jsp"><i class="fa fa-sign-in-alt"></i> Login</a>
</div>

<h1>Bienvenue 👋</h1>

<div class="container">

    <!-- LÉGUMES -->
    <div class="card">
        <a href="produits?cat=legumes">
            <img src="images/legumes.jpg">
            <h3>Legumes</h3>
        </a>
    </div>

    <!-- FRUITS -->
    <div class="card">
        <a href="produits?cat=fruits">
            <img src="images/fruits.jpg">
            <h3>Fruits</h3>
        </a>
    </div>

    <!-- ALIMENTAIRE -->
    <div class="card">
        <a href="produits?cat=alimentaire">
            <img src="images/alimentaire.jpg">
            <h3>Produits</h3>
        </a>
    </div>

</div>

</body>
</html>