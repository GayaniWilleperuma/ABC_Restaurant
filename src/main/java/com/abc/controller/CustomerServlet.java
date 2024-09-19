package com.abc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.Customer;
import com.abc.service.CusServices;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private CusServices customerservice = new CusServices();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        String birthdate = request.getParameter("birthdate");


        Customer customer = new Customer();
        customer.setCustomer_name(name);
        customer.setEmail(email);
        customer.setMobile(number);
        customer.setAddress(address);
        customer.setBirth_date(birthdate);

      
        boolean isRegistered = customerservice.registerCustomer(customer);

        if (isRegistered) {
        
            request.setAttribute("successMessage", "successfully registered");
        } else {
            request.setAttribute("errorMessage", "try again please");
        }

        // Forward the request back to the JSP page
        request.getRequestDispatcher("CusRegister.jsp").forward(request, response);
		doGet(request, response);
	}

}
