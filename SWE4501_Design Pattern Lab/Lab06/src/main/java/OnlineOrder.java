public class OnlineOrder extends Order {
    @Override
    public double calculateTotal() {
        return items.size() * 10.0;
    }
}
