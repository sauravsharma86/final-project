package logic;

import db.FetchUserDAO;
import db.RegistrationDAO;
import pojo.User;

public class Manager {

    public static void registerAnUser(User user) {
        RegistrationDAO.save(user);
    }

    public static User validateUser(String email, String password) {
        return FetchUserDAO.get(email, password);
    }

    public static boolean isEmailAlreadyRegistered(String email) {
        return FetchUserDAO.isEmailExists(email);
    }
}
