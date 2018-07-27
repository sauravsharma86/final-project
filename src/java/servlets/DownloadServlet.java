package servlets;

import db.DBHelper;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
        Long contentId = Long.parseLong(request.getParameter("contentId"));
        ResultSet rs = DBHelper.get("select * from content where contentId=" + contentId);
        String fileName = null;
        byte[] content = null;
        try {
            while (rs.next()) {
                content = rs.getBytes("content");
                fileName = rs.getString("fileName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DownloadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        OutputStream out = response.getOutputStream();
        out.write(content);
        out.flush();
        out.close();
    }

}
