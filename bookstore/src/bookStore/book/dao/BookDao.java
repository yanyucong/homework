package bookStore.book.dao;

import bookStore.book.domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    QueryRunner qr = new QueryRunner();
    public Book queryByBid(int bid){
        String sql = "select * from book where bid = ?";
        Connection conn = JdbcUtil.getConnection();
        try {
            Book book = qr.query(conn, sql, new BeanHandler<Book>(Book.class),bid);
            return book;
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

    public List<Book> queryByCategory(int cid){
        String sql = "select * from book where cid=?";
        Connection conn = JdbcUtil.getConnection();
        try {
            List<Book> books = qr.query(conn, sql, new BeanListHandler<Book>(Book.class), cid);
            return books;
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

    public List<Book> queryAll(){
        String sql = "select * from book";
        Connection conn = JdbcUtil.getConnection();
        try {
            List<Book> bookList = qr.query(conn, sql, new BeanListHandler<Book>(Book.class));
            return bookList;
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
