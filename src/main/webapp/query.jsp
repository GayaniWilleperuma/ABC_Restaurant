<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ask Queries</title>
    <link rel="stylesheet" href="query.css">
    <script>
        function validateForm() {
            const name = document.querySelector('input[name="name"]').value;
            const email = document.querySelector('input[name="email"]').value;
            const message = document.querySelector('textarea[name="message"]').value;
            const errorElement = document.getElementById("error");

            if (!name || !email || !message) {
                errorElement.textContent = "All fields are required.";
                return false;
            }

            const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
            if (!emailPattern.test(email)) {
                errorElement.textContent = "Invalid email format.";
                return false;
            }

            errorElement.textContent = "";
            return true;
        }
    </script>
</head>
<body>
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
 

    <!-- Query form section -->
    <main class="query-form">
        <h2>Enter Queries Here</h2>
        <form name="queryForm" action="submit-query" method="post" onsubmit="return validateForm()">
            <div class="form-group">
                <label for="name">Your Name:</label>
                <input type="text" id="name" name="name" placeholder="Your Name" required>
            </div>

            <div class="form-group">
                <label for="email">Your Email:</label>
                <input type="email" id="email" name="email" placeholder="Your Email" required>
            </div>

            <div class="form-group">
                <label for="message">Your Message:</label>
                <textarea id="message" name="message" placeholder="Your Message" rows="5" required></textarea>
            </div>

            <button type="submit">Submit</button>
        </form>
        <p id="error" class="error-message"></p>
        <p><a href="index.jsp">Back to Home</a></p>
        <% if (request.getAttribute("error") != null) { %>
            <p class="error-message"><%= request.getAttribute("error") %></p>
        <% } %>
    </main>
</body>
</html>
