package bookStore.user.service.exception;

public class EmilIsNotExistException extends RegisterException{
    @Override
    public String getMessage() {
        return "邮箱不存在！！！";
    }
}
