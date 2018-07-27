package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Content;

public class ContentDAO {

    public static List<Content> getUploadContent(long userId) {
        List<Content> list = new ArrayList<Content>();
        ResultSet rs = DBHelper.get("select contentId, uploaderId, uploadedTime,fileName,description from content where uploaderId = " + userId);
        try {
            while (rs.next()) {
                Long contentId = rs.getLong("contentId");
                String uploadedTime = rs.getString("uploadedTime");
                String fileName = rs.getString("fileName");
                String description = rs.getString("description");
                list.add(new Content(contentId, userId, uploadedTime, fileName, description));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
