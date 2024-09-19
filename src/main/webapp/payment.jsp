<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payments Here</title>
    <link rel="stylesheet" href="payment.css">

    <script>
        function validateForm() {
            const paymentType = document.querySelector('input[name="paymentType"]:checked').value;
            const cardNumber = document.querySelector('input[name="cardNumber"]').value;
            const expiryDate = document.querySelector('input[name="expiryDate"]').value;
            const cvc = document.querySelector('input[name="cvc"]').value;
            const errorElement = document.getElementById("error");

            if (paymentType === "visa") {
                if (cardNumber.length !== 16) {
                    errorElement.textContent = "Card number must be 16 digits.";
                    return false;
                }
                if (!/^(\d{2}\/\d{2})$/.test(expiryDate)) {
                    errorElement.textContent = "Invalid expiry date format. Use MM/YY.";
                    return false;
                }
                if (cvc.length !== 3) {
                    errorElement.textContent = "CVC must be 3 digits.";
                    return false;
                }
            }
            return true;
        }

        function toggleCardInput() {
            const cardDetails = document.getElementById("cardDetails");
            const paymentType = document.querySelector('input[name="paymentType"]:checked').value;
            cardDetails.style.display = paymentType === "visa" ? "block" : "none";
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

    <div class="payment-form">
        <h2>Make a Payment</h2>
        <form name="paymentForm" action="submit-payment" method="post" onsubmit="return validateForm()">
            <div class="form-group">
                <input type="text" name="reservationId" placeholder="Reservation ID" required>
            </div>

            <div class="form-group">
                <input type="number" name="amount" placeholder="Amount" step="0.01" required>
            </div>

            <div class="form-group">
                <label>Payment Type:</label>
                <input type="radio" name="paymentType" value="cash" checked onclick="toggleCardInput()"> Cash
                <input type="radio" name="paymentType" value="visa" onclick="toggleCardInput()"> Visa
            </div>

            <div id="cardDetails" class="form-group" style="display: none;">
                <input type="text" name="cardNumber" placeholder="Card Number" maxlength="16">
                <input type="text" name="nameOnCard" placeholder="Name on Card">
                <input type="text" name="expiryDate" placeholder="MM/YY" maxlength="5">
                <input type="text" name="cvc" placeholder="CVC" maxlength="3">
            </div>

            <div id="error" class="error-message"></div>
            <button type="submit" class="submit-btn">Confirm Payment</button>
            <a href="cancel-payment.jsp" class="cancel-btn">Cancel Payment</a>
        </form>
    </div>
</body>
</html>
