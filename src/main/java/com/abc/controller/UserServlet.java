package com.abc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.model.User;
import com.abc.service.UserServices;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

   
	private static final long serialVersionUID = 1L;
	private final UserServices userService;

    // Constructor-based dependency injection
    public UserServlet() {
        this.userService = new UserServices();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "register":
                handleRegister(req, resp);
                break;

            case "login":
                handleLogin(req, resp);
                break;

            default:
                resp.sendRedirect("error.jsp");
                break;
        }
    }

    private void handleRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String usertype = req.getParameter("usertype");

        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setUser_type(usertype);

        userService.registerUser(user);
        resp.sendRedirect("login.jsp");
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.loginUser(username, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            
            switch (user.getUser_type()) {
                case "admin":
                    resp.sendRedirect("admin-dashboard.jsp");
                    break;
                case "staff":
                    resp.sendRedirect("staff-dashboard.jsp");
                    break;
                default:
                    resp.sendRedirect("user-dashboard.jsp");
                    break;
            }
        } else {
            resp.sendRedirect("login.jsp?error=1");
        }
    }
}
