public class OrderFactory {
    public static Order createOrder(String orderType) {
        switch (orderType) {
            case "online":
                return new OnlineOrder();
            case "in_store":
                return new InStoreOrder();
            default:
                throw new IllegalArgumentException("Invalid order type.");
        }
    }
}
