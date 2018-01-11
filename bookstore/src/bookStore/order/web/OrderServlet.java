package bookStore.order.web;

import bookStore.cart.domain.Cartltem;
import bookStore.order.domain.Book_Count;
import bookStore.order.domain.Order;
import bookStore.order.service.OrderService;
import bookStore.order.service.exception.OrderIsNotCompleteException;
import bookStore.user.dao.UserDao;
import bookStore.user.domain.User;
import util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BaseServlet{
    UserDao userDao = new UserDao();
    public String add(HttpServletRequest request, HttpServletResponse response)throws SQLException{
        List<Cartltem> cart = (List<Cartltem>) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("user");
        User user1 = userDao.queryByUsername(user.getUsername());
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().split("-")[1];
        request.getSession().setAttribute("oid",s);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(new Date());
        request.getSession().setAttribute("time",format);
        double money = (Double) request.getSession().getAttribute("money");
        request.getSession().setAttribute("money",money);
        OrderService.add(s,format,money,user1,"",cart);
        return "f:/jsps/order/desc.jsp";
    }


    public String findOrdersByUid(HttpServletRequest request,HttpServletResponse response)throws SQLException{
        User user = (User) request.getSession().getAttribute("user");
        User user1 = userDao.queryByUsername(user.getUsername());
        String uid = user1.getUid();
        List<Order> orders = OrderService.findOrderByUid(uid);
        List<Book_Count> book_counts = OrderService.findUserCart();
//        System.out.println(book_counts);
        request.getSession().setAttribute("order",orders);
        request.getSession().setAttribute("book_count",book_counts);

        return "f:/jsps/order/list.jsp";
    }

    public String findOrderByOid(HttpServletRequest request,HttpServletResponse response)throws SQLException{
        String oid = request.getParameter("oid");
        String ordertime = request.getParameter("ordertime");
        String price = request.getParameter("price");
//        System.out.println(oid);
        Order order = OrderService.findOrderByOid(oid);
        order.setState(2);
        List<Book_Count> book_counts = OrderService.findUserCart(oid);
//        System.out.println(book_counts);
        request.getSession().setAttribute("book_count",book_counts);
        request.getSession().setAttribute("oid",oid);
        request.getSession().setAttribute("ordertime",ordertime);
        request.getSession().setAttribute("price",price);

        return "f:/jsps/order/desc.jsp";
    }

    public String findOrder(HttpServletRequest request,HttpServletResponse response) throws SQLException, OrderIsNotCompleteException {
        String oid = request.getParameter("oid");
        Order order = OrderService.findOrderByOid(oid);
        order.setState(3);
        if (order.getState()==0||order.getState()==1||order.getState()==2){
            OrderIsNotCompleteException exception = new OrderIsNotCompleteException();
            throw exception;
        }

        if (order.getState()==3){
            String oid1 = order.getOid();
            List<Book_Count> book_counts = OrderService.findUserCart(oid1);
            request.getSession().setAttribute("book_count",book_counts);
        }
        return "f:/jsps/order/msg.jsp";
    }


}
