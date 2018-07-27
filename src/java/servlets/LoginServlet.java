package servlets;

import db.ContentDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Manager;
import pojo.User;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("userPassword");
        if (email == null || password == null || (email.trim().equalsIgnoreCase("")) || (password.trim().equalsIgnoreCase(""))) {
            request.setAttribute("error", "Please provide email and password.");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } else {
            User user = Manager.validateUser(email, password);
            if (user != null) {
                request.getSession().setAttribute("loggedInUser", user);
                request.getSession().setAttribute("ownContent", ContentDAO.getUploadContent(user.getUserId()));
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("error", "Invalid user.Please provide valid credentials.");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }
    }
}
