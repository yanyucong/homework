package bookStore.cart.domain;

import java.util.Map;

public class Cart {
    private Map<String,Cartltem> cartltemMap;

    @Override
    public String toString() {
        return "Cart{" +
                "cartltemMap=" + cartltemMap +
                '}';
    }

    public Map<String, Cartltem> getCartltemMap() {
        return cartltemMap;
    }

    public void setCartltemMap(Map<String, Cartltem> cartltemMap) {
        this.cartltemMap = cartltemMap;
    }

    public Cart() {

    }
}
