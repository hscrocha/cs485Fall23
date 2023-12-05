package edu.loyola.cs485.controller;

import edu.loyola.cs485.model.dao.UserDAO;
import edu.loyola.cs485.model.entity.User;

public class UserService {

    public User login(String login, String password) throws Exception {
        UserDAO dao = new UserDAO();
        return dao.login(login,password);
    }
}
