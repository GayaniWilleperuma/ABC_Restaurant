<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Welcome to Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="dashboardAdmin.css" />
    
   
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
  
  <main>
    <section id="manage-reservations">
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
                <!-- Dynamic rows will be added here -->
            </tbody>
        </table>
        <button id="add-reservation-btn">Add Reservation</button>
    </section>
</main>

<script>
//Add a new row to the table
function addRow(tableId) {
    const table = document.getElementById(tableId).getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();

    // Define the row with input fields
    newRow.innerHTML = `
        <td><input type="text" placeholder="Reservation ID"></td>
        <td><input type="text" placeholder="Customer Name"></td>
        <td><input type="date"></td>
        <td><input type="time"></td>
        <td>
            <button onclick="saveRow(this)">Save</button>
            <button onclick="deleteRow(this)">Delete</button>
        </td>`;
}

// Save the data from input fields to table cells
function saveRow(button) {
    const row = button.parentNode.parentNode;
    const inputs = row.querySelectorAll('input');

    inputs.forEach(input => {
        const value = input.value;
        const cell = input.parentNode;
        cell.textContent = value;  // Replace input with its value
    });

    // Replace save button with edit/delete buttons
    const actionCell = row.lastElementChild;
    actionCell.innerHTML = `
        <button onclick="editRow(this)">Edit</button>
        <button onclick="deleteRow(this)">Delete</button>`;
}

// Edit an existing row
function editRow(button) {
    const row = button.parentNode.parentNode;
    const cells = row.querySelectorAll('td');

    // Replace text content with input fields
    for (let i = 0; i < cells.length - 1; i++) {
        const value = cells[i].textContent;
        cells[i].innerHTML = `<input type="text" value="${value}">`;
    }

    // Change buttons to Save/Delete
    const actionCell = cells[cells.length - 1];
    actionCell.innerHTML = `
        <button onclick="saveRow(this)">Save</button>
        <button onclick="deleteRow(this)">Delete</button>`;
}

// Delete a row from the table
function deleteRow(button) {
    const row = button.parentNode.parentNode;
    row.remove();
}


</script>
  