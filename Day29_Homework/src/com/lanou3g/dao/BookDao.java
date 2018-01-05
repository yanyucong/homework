package com.lanou3g.dao;

import com.lanou3g.bean.Book;
import com.lanou3g.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BookDao {
    private QueryRunner qr = new QueryRunner();

    public List<Book> query(){
        String sql = "select * from book";
        Connection conn = JdbcUtil.getConnection();
    List<Book> books = null;
        try {
            books = qr.query(conn, sql, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
