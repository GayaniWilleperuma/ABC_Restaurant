package com.abc.controller;
import com.abc.model.Queries;
import com.abc.service.QServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private QServices queryService = new QServices();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        // Input validation
        if (name == null || name.isEmpty() || email == null || email.isEmpty() || message == null || message.isEmpty()) {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("submit-query.jsp").forward(request, response);
            return; // Stop further execution if validation fails
        }

        // Create and populate the Query object
        Queries query = new Queries();
        query.setName(name);
        query.setEmail(email);
        query.setMessage(message);

        try {
            // Call the service method to submit the query
            queryService.submitQuery(query);
            // Redirect to success page upon successful query submission
            response.sendRedirect("query-success.jsp");
        } catch (Exception e) {
            // Handle any exceptions during query submission
            request.setAttribute("error", "Failed to submit query: " + e.getMessage());
            request.getRequestDispatcher("submit-query.jsp").forward(request, response);
        }
    }
}