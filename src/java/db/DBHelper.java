package db;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

    public static boolean persist(String query, Object[] values) {
        boolean flag = false;
        PreparedStatement pstmt = null;
        try {
            pstmt = DBConnection.get().prepareStatement(query);
            for (int i = 0; i < values.length; i++) {
                Object obj = values[i];
                pstmt.setObject((i + 1), obj);
            }
            System.out.println("Query is : "+pstmt.toString());
            pstmt.execute();
            flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return flag;
    }

    // Fetching the data
    public static ResultSet get(String sql) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = DBConnection.get().createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return rs;
    }
}
