package com.abc.controller;

import com.abc.model.Payments;
import com.abc.service.PayServices;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

@WebServlet("/submit-payment")
public class PaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // PaymentService to handle business logic related to payments
    private PayServices paymentService = new PayServices();

    /**
     * Handles POST requests for submitting a payment
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get parameters from the payment form
        String reservationId = request.getParameter("reservationId");
        String paymentDateStr = request.getParameter("paymentDate");
        double amount = 0;
        String paymentStatus = request.getParameter("paymentStatus");

        // Convert the amount to double
        try {
            amount = Double.parseDouble(request.getParameter("amount"));
        } catch (NumberFormatException e) {
            // Handle invalid amount format
            request.setAttribute("error", "Invalid amount format");
            request.getRequestDispatcher("payment.jsp").forward(request, response);
            return; // Stop further execution if amount is invalid
        }

        // Parse payment date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date paymentDate;
        try {
            paymentDate = dateFormat.parse(paymentDateStr);
        } catch (ParseException e) {
            // Handle invalid date format
            request.setAttribute("error", "Invalid date format");
            request.getRequestDispatcher("payment.jsp").forward(request, response);
            return; // Stop execution if date is invalid
        }

        // Create and set payment details into the Payments object
        Payments payment = new Payments();
        payment.setReservation_id(reservationId);
        payment.setPayment_date(paymentDate);
        payment.setAmount(amount);
        payment.setPayment_status(paymentStatus);

        // Process the payment
        try {
            paymentService.processPayment(payment);
            // Redirect back to payment.jsp with a success message
            response.sendRedirect("payment.jsp?success=true");
        } catch (Exception e) {
            // Handle exceptions and forward to the error page with a descriptive message
            request.setAttribute("error", "Payment processing failed: " + e.getMessage());
            request.getRequestDispatcher("payment.jsp").forward(request, response);
        }
    }
}
