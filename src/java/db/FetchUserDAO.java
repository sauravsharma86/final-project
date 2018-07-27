package db;

import java.sql.ResultSet;
import pojo.User;

public class FetchUserDAO {

    public static User get(String email, String pw) {
        User user = null;
        String sqlQuery = "select * from user where email = '" + email + "' and password = '" + pw + "'";
        ResultSet rs = DBHelper.get(sqlQuery);
        try {
            if (rs.next()) {
                long userId = rs.getLong("userId");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String phoneNumber = rs.getString("phoneNumber");
                String address = rs.getString("address");
                user = new User(userId, firstName, lastName, phoneNumber, address, email, pw);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public static boolean isEmailExists(String email) {
        boolean flag = false;        
        String sqlQuery = "select * from user where email = '" + email + "'";
        ResultSet rs = DBHelper.get(sqlQuery);
        try {
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }
}
