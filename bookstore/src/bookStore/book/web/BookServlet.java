package bookStore.book.web;

import bookStore.book.dao.BookDao;
import bookStore.book.domain.Book;
import util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends BaseServlet{
        BookDao bookDao = new BookDao();
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException{
        List<Book> books = bookDao.queryAll();
        request.setAttribute("books",books);
        return "f:/jsps/book/list.jsp";
    }

    public String findBookByCategory(HttpServletRequest request,HttpServletResponse response) throws SQLException{
        int cid = Integer.parseInt(request.getParameter("cid"));
        List<Book> books = bookDao.queryByCategory(cid);
        request.setAttribute("books",books);
        return "f:/jsps/book/list.jsp";
    }

    public String load(HttpServletRequest request,HttpServletResponse response)throws SQLException{
        int bid = Integer.parseInt(request.getParameter("bid"));
        Book book = bookDao.queryByBid(bid);
        request.setAttribute("book",book);
        return "f:/jsps/book/desc.jsp";
    }
}
