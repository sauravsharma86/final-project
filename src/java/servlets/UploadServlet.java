package servlets;

import db.ContentDAO;
import db.DBHelper;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import pojo.User;

@javax.servlet.annotation.MultipartConfig
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
        Part attachment = request.getPart("attachment");
        String description = request.getParameter("description");
        String attachmentName = attachment.getSubmittedFileName();
        InputStream filecontent = attachment.getInputStream();
        byte[] attachmentContent = new byte[filecontent.available()];
        filecontent.read(attachmentContent);
        String sqlQuery = "insert into content (uploaderId,content,uploadedTime,fileName,description) values(?,?,?,?,?)";
        Long userId = ((User) request.getSession().getAttribute("loggedInUser")).getUserId();
        Date date = new Date();
        String dateValue = date.toString();
        Object[] values = {userId, attachmentContent, dateValue, attachmentName, description};
        DBHelper.persist(sqlQuery, values);
        request.getSession().setAttribute("ownContent", ContentDAO.getUploadContent(userId));
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
    }

}
