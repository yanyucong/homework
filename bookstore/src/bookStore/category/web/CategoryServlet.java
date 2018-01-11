package bookStore.category.web;

import bookStore.book.domain.Book;
import bookStore.category.dao.CategoryDao;
import bookStore.category.domain.Category;
import util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet",urlPatterns = "/cate")
public class CategoryServlet extends BaseServlet{
        CategoryDao categoryDao = new CategoryDao();
    public String findAllCategory(HttpServletRequest request, HttpServletResponse response)throws SQLException{
//        String cid = request.getParameter("cid");
        List<Category> categories = categoryDao.queryALL();
        HttpSession session = request.getSession();
        session.setAttribute("cate",categories);
        return "f:/jsps/left.jsp";
    }
}
