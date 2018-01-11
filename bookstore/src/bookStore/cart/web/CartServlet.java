package bookStore.cart.web;

import bookStore.book.dao.BookDao;
import bookStore.book.domain.Book;
import bookStore.cart.domain.Cartltem;
import util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends BaseServlet{
    BookDao bookDao = new BookDao();
    public String addCartltem(HttpServletRequest request, HttpServletResponse response)throws SQLException{
        HttpSession session = request.getSession();
        List<Cartltem> cart = (List<Cartltem>) session.getAttribute("cart");
        int count = Integer.parseInt(request.getParameter("count"));
//        System.out.println(count);
        int bid = Integer.parseInt(request.getParameter("bid"));
        Book book = bookDao.queryByBid(bid);
        Cartltem cartltem = new Cartltem(book,count);
        cart.add(cartltem);
//        System.out.println(b);
        session.setAttribute("cart",cart);
       return "f:/jsps/cart/list.jsp";
    }

    public String clearCart(HttpServletRequest request,HttpServletResponse response)throws SQLException{
        HttpSession session = request.getSession();
        List<Cartltem> cart = (List<Cartltem>) session.getAttribute("cart");
        cart.clear();
        session.setAttribute("cart",cart);
        return "f:/jsps/cart/list.jsp";
    }

    public String deleteCartltem(HttpServletRequest request,HttpServletResponse response)throws SQLException{
        HttpSession session = request.getSession();
        List<Cartltem> cart = (List<Cartltem>) session.getAttribute("cart");
        String bid = request.getParameter("bid");
//        System.out.println(bid);
        int i = Integer.parseInt(bid);
//        Book book = bookDao.queryByBid(i);
        for (int j = 0; j < cart.size(); j++) {
            if (cart.get(j).getBook().getBid().equals(i)){
                cart.remove(cart.get(j));
            }
        }
        session.setAttribute("cart",cart);
        return "f:/jsps/cart/list.jsp";
    }
}
