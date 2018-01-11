package bookStore.order.service.exception;

public class OrderIsNotCompleteException extends Exception {
    @Override
    public String getMessage() {
        return "订单未完成";
    }
}
