package bookStore.user.service.exception;

public class UsernameIsNotExistException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名不存在";
    }
}
