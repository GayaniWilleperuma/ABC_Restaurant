<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <title>Make Your Reservation</title>
    <link rel="stylesheet" type="text/css" href="Reservations.css">
    <script>
        function showMessage(message) {
            if (message) {
                alert(message); 
            }
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
<div class="reservation-form-container">
    <form action="reservation" method="post">
        <h2>Make a Reservation</h2>

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>

        <div class="form-group">
            <label for="reservationDate">Date:</label>
            <input type="date" id="reservationDate" name="reservationDate" required>
        </div>

        <div class="form-group">
            <label for="time">Time:</label>
            <input type="time" id="time" name="time" required>
        </div>


        <div class="form-group">
            <label for="serviceType">Service:</label>
            <select id="serviceType" name="serviceType" required>
                <option value="Breakfast">Breakfast</option>
                <option value="Lunch">Lunch</option>
                <option value="Dinner">Dinner</option>
            </select>
        </div>

        <button type="submit" class="submit-btn">Reserve</button>
    </form>
    <div class="success-message">
        <h1>Reserved</h1>
    </div>
    
</div>
<script>
    <% String message = (String) request.getAttribute("message"); %>
    showMessage("<%= message != null ? message : "" %>");
</script>


</body>
</html>