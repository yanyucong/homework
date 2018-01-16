package service;

import dao.UserDao;
import domain.User;

public class UserService {
    UserDao ud = new UserDao();
    public User findUser(String username){
        User user = ud.queryByUsername(username);
        return user;
    }

    public void add(User user){
        ud.insert(user);
    }
}
