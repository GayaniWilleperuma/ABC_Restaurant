package com.abc.service;

import com.abc.dao.UsersDao;
import com.abc.model.User;

public class UserServices {
	private UsersDao userdao = new UsersDao();

    public void registerUser(User user) {
        userdao.registerUser(user);
    }

    public User loginUser(String username, String password) {
        return userdao.loginUser(username, password);
    }
}
