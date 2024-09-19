<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ABC Restaurant</title>
    <link rel="stylesheet" type="text/css" href="login.css" />
    
   
  <body>
    <!-- Header section starts -->
    <header>
      <a href="#" class="logo"><i class="fas fa-utensils"></i>ABC Restaurant</a>
      <div id="menu-bar" class="fas fa-bars"></div>
      <nav class="navbar">
          <a href="index.jsp">Home</a>
          <a href="products.html">Products</a>
          <a href="gallery.html">Gallery</a>
          <a href="facilities.html">Facilities</a>
          <a href="availability.html">Availability</a>
          <a href="reservation.jsp">Reservations</a>
          <a href="payment.jsp">Payment</a>
          <a href="cusregister.jsp">Register Here</a>
          <a href="login.jsp">Login</a>
          <a href="query.jsp">Ask Queries from us</a>

      </nav>
  </header>

   <div class="login-container">
    <form action="user" method="post">
        <input type="hidden" name="action" value="login"/>

        <h2>Login</h2>

        <label for="username">Username:</label>
        <input type="text" name="username" id="username" required/>

        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required/>

        <input type="submit" value="Login"/>
    </form>

    <% if (request.getParameter("error") != null) { %>
        <p class="error-message">Invalid username or password!</p>
    <% } %>
</div>

  </body>
</html>