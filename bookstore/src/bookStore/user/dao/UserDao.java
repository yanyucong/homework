package bookStore.user.dao;

import bookStore.user.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private QueryRunner qr = new QueryRunner();
        Connection conn = JdbcUtil.getConnection();
    public User queryByUsername(String username){
        String sql = "select * from user where username = ?";
        User user = new User();
        try {
            user = qr.query(conn,sql,new BeanHandler<User>(User.class),username);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertUser(User user){
        String sql = "insert into user values(?,?,?,?,?,?)";
        try {
            qr.update(conn,sql,user.getUid(),user.getUsername(),user.getPASSWORD(),user.getEmail(),user.getCode(),user.isState());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User queryByEmail(String email){
        String sql = "select * from user where email = ?";
        User user = new User();
        try {
            user = qr.query(conn,sql,new BeanHandler<User>(User.class),email);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
