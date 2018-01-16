package action;

import com.opensymphony.xwork2.ActionSupport;
import domain.User;
import service.UserService;

public class UserAction extends ActionSupport{
    private User user;
    UserService us = new UserService();
        public String register(){
            User user1 = us.findUser(this.user.getUsername());
            if (user1 == null){
                us.add(user);
            return SUCCESS;
            }
            return ERROR;
        }

        public String login(){
            User usUser = us.findUser(this.user.getUsername());
            if (usUser.getUsername().equals(user.getUsername())&&usUser.getPassword().equals(user.getPassword())){
                return SUCCESS;
            }
            return ERROR;
        }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
