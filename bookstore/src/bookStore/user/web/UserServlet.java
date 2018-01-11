package bookStore.user.web;

import bookStore.cart.domain.Cart;
import bookStore.cart.domain.Cartltem;
import bookStore.user.dao.UserDao;
import bookStore.user.domain.User;
import bookStore.user.service.UserService;
import bookStore.user.service.exception.LoginException;
import bookStore.user.service.exception.RegisterException;
import org.apache.commons.beanutils.BeanUtils;
import util.BaseServlet;
import util.Email;

import javax.mail.MessagingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    Email email = new Email();
    User user = new User();
    UserDao userDao = new UserDao();
    public String login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(user,parameterMap);
//            userDao.queryByUsername(user.getUsername());
            try {
                UserService.login(user);
                request.getSession().setAttribute("user",user);
                List<Cartltem> cart = new ArrayList<>();
                request.getSession().setAttribute("cart",cart);
        return "r:/jsps/main.jsp";
            } catch (LoginException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return "f:/jsps/user/login.isp";
    }

    public String register(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(user,parameterMap);
//            userDao.insertUser(user);
            try {
                String s = UUID.randomUUID().toString();
                String[] s2 = s.split("-");
                System.out.println(Arrays.toString(s2));
                String s1 = s2[1];
                user.setUid(s1);
                user.setUsername(user.getUsername());
                user.setPASSWORD(user.getPASSWORD());
                user.setEmail(user.getEmail());
                user.setCode(s);
                user.setState(0);
                try {
                    UserService.register(user);
                email.sendMail(user.getEmail());
                } catch (RegisterException e) {
                    e.printStackTrace();
                }
                userDao.insertUser(user);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return "f:/jsps/user/login.jsp";
    }
}
