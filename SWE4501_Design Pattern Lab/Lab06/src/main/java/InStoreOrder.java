public class InStoreOrder extends Order {
    private String pickupTime;
    private double discount;

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public void applyDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculateTotal() {
        double total = items.size() * 10.0;
        if (discount > 0) {
            total -= discount;
        }
        return total;
    }

    @Override
    public String toString() {
        return super.toString() + ", Pickup Time: " + pickupTime;
    }
}
