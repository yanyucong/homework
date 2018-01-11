package bookStore.order.dao;

import bookStore.book.domain.Book;
import bookStore.cart.domain.Cart;
import bookStore.order.domain.Book_Count;
import bookStore.order.domain.Order;
import bookStore.order.domain.Orderitem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class OrderDao {
    QueryRunner qr = new QueryRunner();
    Connection conn = JdbcUtil.getConnection();
    public List<Cart> queryOrderItemByOid(int oid){
        String sql = "select * from orderitem where oid = ?";
        try {
            List<Cart> carts = qr.query(conn, sql, new BeanListHandler<Cart>(Cart.class), oid);
            return carts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    public Cart queryOrderitemByiid(int iid){
        String sql = "select * from orderitem where iid = ?";
        try {
            Cart cart = qr.query(conn, sql, new BeanHandler<Cart>(Cart.class), iid);
            return cart;
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    public void addOrders(Orderitem orderitem){

        String sql = "insert into orderitem values(?,?,?,?,?)";
        UUID uuid = UUID.randomUUID();
        String[] split = uuid.toString().split("-");
        String s = split[1];
        try {
            qr.update(conn,sql,orderitem.getIid(),orderitem.getCOUNT(),orderitem.getSubtotal(),orderitem.getOid(),orderitem.getBid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void addOrder(Order order){
        String sql = "insert into orders values(?,?,?,?,?,?)";

//        System.out.println(format);
        try {
            qr.update(conn,sql,order.getOid(),order.getOrdertime(),order.getPrice(),order.getState(),order.getUid(),order.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public List<Order> queryOrdersByUid(String uid){
        String sql = "select * from orders where uid = ?";
        try {
            List<Order> orders = qr.query(conn, sql, new BeanListHandler<Order>(Order.class), uid);
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book_Count> queryBidByoid(){
        String sql = "SELECT b.*,COUNT,o2.oid FROM book b INNER JOIN orderitem o1 on b.bid = o1.bid INNER JOIN orders o2 ON o2.oid = o1.oid";
        try {
            List<Book_Count> list = qr.query(conn, sql, new BeanListHandler<Book_Count>(Book_Count.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Order queryOrderByOid(String oid){
        String sql = "select * from orders where oid = ?";
        try {
            Order order = qr.query(conn, sql, new BeanHandler<Order>(Order.class), oid);
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book_Count> queryBidByoid(String oid){
        String sql = "SELECT b.*,COUNT,o2.oid FROM book b INNER JOIN orderitem o1 on b.bid = o1.bid INNER JOIN orders o2 ON o2.oid = o1.oid where o2.oid = ?";
        try {
            List<Book_Count> list = qr.query(conn, sql, new BeanListHandler<Book_Count>(Book_Count.class),oid);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
