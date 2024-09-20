<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Welcome to Staff Dashboard</title>
    <link rel="stylesheet" type="text/css" href="dashboardStaff.css" />
    
   
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
  <section class="content">
    <!-- Manage Reservations Section -->
    <div class="box">
        <h2>Manage Reservations</h2>
        <table id="reservations-table">
            <thead>
                <tr>
                    <th>Reservation ID</th>
                    <th>Customer Name</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Reservation rows will be added here dynamically -->
            </tbody>
        </table>
        <button class="btn" onclick="addReservationRow()">Add Reservation</button>
    </div>

    <!-- Respond to Queries Section -->
    <div class="box">
        <h2>Respond to Queries</h2>
        <form id="query-form">
            <div class="form-group">
                <input type="text" placeholder="Enter Query ID" required>
            </div>
            <div class="form-group">
                <input type="text" placeholder="Enter Customer Name" required>
            </div>
            <div class="form-group">
                <textarea placeholder="Type your response here" required></textarea>
            </div>
            <button type="submit" class="btn">Send Response</button>
        </form>
    </div>

    <!-- Manage Payments Section -->
    <div class="box">
        <h2>Manage Payments</h2>
        <form id="payment-form">
            <div class="form-group">
                <input type="text" placeholder="Enter Payment ID" required>
            </div>
            <div class="form-group">
                <input type="number" placeholder="Enter Amount" required>
            </div>
            <div class="form-group">
                <select required>
                    <option value="" disabled selected>Status</option>
                    <option value="Pending">Pending</option>
                    <option value="Completed">Completed</option>
                </select>
            </div>
            <button type="submit" class="btn">Update Payment</button>
        </form>
    </div>
</section>

<script>// Manage Reservations
function addReservationRow() {
    const table = document.querySelector('#reservations-table tbody');
    const newRow = table.insertRow();

    newRow.innerHTML = `
        <td>1</td>
        <td><input type="text" placeholder="Customer Name" required></td>
        <td><input type="date" required></td>
        <td><input type="time" required></td>
        <td>
            <button class="btn" onclick="confirmReservation(this)">Confirm</button>
            <button class="btn" onclick="deleteRow(this)">Delete</button>
        </td>`;
}

function confirmReservation(button) {
    const row = button.closest('tr');
    const inputs = row.querySelectorAll('input');

    inputs.forEach(input => {
        const value = input.value;
        if (!value) {
            alert('Please fill out all fields before confirming.');
            return;
        }
        const cell = input.parentElement;
        cell.textContent = value;
    });

    const actionCell = row.querySelector('td:last-child');
    actionCell.innerHTML = `
        <button class="btn" disabled>Confirmed</button>
        <button class="btn" onclick="deleteRow(this)">Delete</button>`;
}

// Delete a row
function deleteRow(button) {
    const row = button.closest('tr');
    row.remove();
}

// Handle form submission for query response
document.getElementById('query-form').addEventListener('submit', function(event) {
    event.preventDefault();
    alert('Query response sent!');
    this.reset();
});

// Handle form submission for payment update
document.getElementById('payment-form').addEventListener('submit', function(event) {
    event.preventDefault();
    alert('Payment updated!');
    this.reset();
});

// Logout function
function logout() {
    if (confirm('Are you sure you want to log out?')) {
        window.location.href = 'homepage.html';  // Replace with the actual home page URL
    }
}
</script>
</body>
</html>
  
  