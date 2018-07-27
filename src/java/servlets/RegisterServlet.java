package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Manager;
import pojo.User;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
        String fn = request.getParameter("fn");
        String ln = request.getParameter("ln");
        String pn = request.getParameter("pn");
        String address = request.getParameter("addr");
        String email = request.getParameter("email");
        String pw = request.getParameter("userPassword");

        boolean validInputs = true;
        StringBuffer buffer = new StringBuffer();

        if (fn == null || fn.trim() == "") {
            validInputs = false;
            buffer.append("\nFirst Name should not be empty.");
        } else if (ln == null || ln.trim() == "") {
            validInputs = false;
            buffer.append("\nLast Name should not be empty.");
        } else if (pn == null || pn.trim() == "") {
            validInputs = false;
            buffer.append("\nPhone number should not be empty.");
        } else if (address == null || address.trim() == "") {
            validInputs = false;
            buffer.append("\nAddres should not be empty.");
        } else if (email == null || email.trim() == "") {
            validInputs = false;
            buffer.append("\nEmail should not be empty.");
        } else if (pw == null || pw.trim() == "") {
            validInputs = false;
            buffer.append("\nPassword should not be empty.");
        } else if (Manager.isEmailAlreadyRegistered(email)) {
            validInputs = false;
            buffer.append("\nAlready registered with this email.");
        }

        if (!validInputs) {
            request.setAttribute("error", buffer.toString());
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        } else {
            User user = new User(fn, ln, pn, address, email, pw);
            Manager.registerAnUser(user);
            request.getSession().setAttribute("loggedInUser", user);
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        }
    }

}
