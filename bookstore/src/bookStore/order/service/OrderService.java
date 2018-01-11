package bookStore.order.service;

import bookStore.book.domain.Book;
import bookStore.cart.domain.Cartltem;
import bookStore.order.dao.OrderDao;
import bookStore.order.domain.Book_Count;
import bookStore.order.domain.Order;
import bookStore.order.domain.Orderitem;
import bookStore.user.domain.User;

import java.util.List;
import java.util.UUID;

public class OrderService {
    private static OrderDao orderDao = new OrderDao();
    public static void add(String oid,String format,double d,User user, String address, List<Cartltem> cart){
        Order order = new Order();
        order.setState(1);
        int state = 0;
        order.setOid(oid);
        order.setOrdertime(format);
        order.setPrice(d);
        order.setState(state);
        order.setUid(user.getUid());
        order.setAddress(address);
        orderDao.addOrder(order);

        for (int i = 0; i < cart.size(); i++) {
            Book book = cart.get(i).getBook();
            int count = cart.get(i).getCount();
            UUID uuid1 = UUID.randomUUID();
            String s1 = uuid1.toString().split("-")[1];
            double sum = count * book.getPrice();
            Orderitem o = new Orderitem();
            o.setIid(s1);
            o.setCOUNT(count);
            o.setSubtotal(sum);
            o.setOid(order.getOid());
            o.setBid(book.getBid());
            orderDao.addOrders(o);
        }

    }

    public static List<Order> findOrderByUid(String uid){
        List<Order> orders = orderDao.queryOrdersByUid(uid);
        return orders;
    }

    public static List<Book_Count> findUserCart(){
        List<Book_Count> book_counts = orderDao.queryBidByoid();
//        System.out.println(book_counts);
        return book_counts;
    }

    public static Order findOrderByOid(String oid){
        Order order = orderDao.queryOrderByOid(oid);
//        System.out.println(order);
        return order;
    }

    public static List<Book_Count> findUserCart(String oid){
        List<Book_Count> book_counts = orderDao.queryBidByoid(oid);
        System.out.println(book_counts);
        return book_counts;
    }
}
