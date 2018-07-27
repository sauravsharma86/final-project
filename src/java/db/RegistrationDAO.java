package db;

import pojo.User;

public class RegistrationDAO {

    public static boolean save(User user) {
        String pstmtString = "insert into user (firstName,lastName,phoneNumber,address,email,password) values( ?,  ?,  ?,  ?,  ?,?)";
        Object[] values = {user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getAddress(), user.getEmail(), user.getPassword()};
        return DBHelper.persist(pstmtString, values);
    }

}
