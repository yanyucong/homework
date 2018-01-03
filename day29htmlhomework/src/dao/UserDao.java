package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private QueryRunner qr = new QueryRunner();

    public boolean insertUser(User user){
        String sql = "insert into user values(null,?,?)";
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            int i = qr.update(conn, sql, user.getUsername(), user.getPassword());
            if (i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(conn);
        return false;
    }

    public static User select(String username) throws SQLException {
        User user = new QueryRunner().query(JdbcUtil.getConnection(),
                "select * from user where username = ?",
                new BeanHandler<User>(User.class),
                username);
        return user;
    }
}
