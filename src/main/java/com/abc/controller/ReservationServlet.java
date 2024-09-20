package com.abc.controller;
import com.abc.model.Reservations;
import com.abc.service.ResServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ResServices reservationService = new ResServices();

    /**
     * Default constructor
     */
    public ReservationServlet() {
        super();
    }

    /**
     * Handles GET requests
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Reservation Service is running at: ").append(request.getContextPath());
    }

    /**
     * Handles POST requests
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("name");
        String reservationDate = request.getParameter("reservationDate");
        String time = request.getParameter("time");
        String serviceType = request.getParameter("serviceType");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date parsedDate = dateFormat.parse(reservationDate);
            Reservations reservation = new Reservations();
            reservationService.addReservation(reservation);
            response.sendRedirect("ResSuccess.jsp");
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?error=InvalidDate");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?error=DatabaseIssue");
        }
    }
}

