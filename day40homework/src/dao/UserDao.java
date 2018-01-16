package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    QueryRunner qr = new QueryRunner();
    Connection conn = C3P0Util.getConnection();
    public User queryByUsername(String username){
        try {
            User user = qr.query(conn, "select * from user where username = ?", new BeanHandler<User>(User.class), username);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        C3P0Util.close(null,null,conn);
        return null;
    }

    public void insert(User user){
        try {
            qr.update(conn,"insert into user values(?,?,?,?)",user.getUsername(),user.getPassword(),user.getPhone(),user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        C3P0Util.close(null,null,conn);
    }
}
