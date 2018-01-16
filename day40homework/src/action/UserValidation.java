package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.User;
import service.UserService;

public class UserValidation extends ActionSupport implements ModelDriven<User>{
    UserService us = new UserService();
    private User user = new User();
    private String re_password;

    public String getRe_password() {
        return re_password;
    }

    public void setRe_password(String re_password) {
        this.re_password = re_password;
    }

    public String register(){
//        us.add(user);
        System.out.prin tln(user);
        return SUCCESS;
    }

    public String img(){

        return SUCCESS;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getModel() {
        return user;
    }
}
