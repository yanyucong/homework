package bookStore.category.dao;

import bookStore.category.domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    QueryRunner qr = new QueryRunner();
    public List<Category> queryALL(){
    Connection conn = JdbcUtil.getConnection();
        String sql = "select * from category";
        List<Category> categoryList = null;
        try {
             categoryList= qr.query(conn, sql, new BeanListHandler<Category>(Category.class));
            return categoryList;
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


}
