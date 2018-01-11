package bookStore.user.service;

import bookStore.user.dao.UserDao;
import bookStore.user.domain.User;
import bookStore.user.service.exception.*;


public class UserService {
    private static UserDao userDao = new UserDao();
    public static void register(User user) throws RegisterException {
        User fromDbUser = userDao.queryByUsername(user.getUsername());
        if (fromDbUser.getUsername().equals(user.getUsername())){
            throw new UsernameExistException();
        }
        if (user.getEmail() == null){
            throw new EmilIsNotExistException();
        }
    }

    public static void login(User user) throws LoginException{
        User formUser = userDao.queryByUsername(user.getUsername());
        if (formUser.getUsername() != null){
            if (!user.getPASSWORD().equals(formUser.getPASSWORD())){
                throw new PasswordIsnotMatchesException();
            }
            }else {
                throw new UsernameIsNotExistException();
        }
        }
}
