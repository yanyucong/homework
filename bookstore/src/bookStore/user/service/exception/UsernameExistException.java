package bookStore.user.service.exception;

public class UsernameExistException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户名已存在！！！";
    }
}
