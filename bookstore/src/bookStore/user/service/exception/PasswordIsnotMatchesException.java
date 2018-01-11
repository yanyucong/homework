package bookStore.user.service.exception;

public class PasswordIsnotMatchesException extends LoginException{
    @Override
    public String getMessage() {
        return "密码不匹配";
    }
}
