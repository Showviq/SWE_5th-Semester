public class Main {
    public static void main(String[] args) {
        // Create a FoodItem
        FoodItem foodItem = new FoodItem("Burger", 5.99);

        // Add toppings using the ToppingDecorator
        foodItem = new ToppingDecorator(foodItem, "Cheese", 1.50);
        foodItem = new ToppingDecorator(foodItem, "Bacon", 2.00);

        // Create an OnlineOrder and add items
        Order onlineOrder = OrderFactory.createOrder("online");
        onlineOrder.addItem(foodItem.toString());
        onlineOrder.addItem("Fries - $2.99");

        // Calculate and display the total for the online order
        double onlineTotal = onlineOrder.calculateTotal();
        System.out.println("Online Order Total: $" + onlineTotal);

        // Create an InStoreOrder and add items
        Order inStoreOrder = OrderFactory.createOrder("in_store");
        inStoreOrder.addItem("Pizza - $8.99");
        inStoreOrder.addItem("Soda - $1.99");

        // Apply a discount and set the pickup time for the in-store order
        InStoreOrder inStoreOrderInstance = (InStoreOrder) inStoreOrder;
        inStoreOrderInstance.applyDiscount(2.00);
        inStoreOrderInstance.setPickupTime("12:30 PM");

        // Calculate and display the total for the in-store order
        double inStoreTotal = inStoreOrder.calculateTotal();
        System.out.println("In-Store Order Total: $" + inStoreTotal);

        // Process payments using PaymentStrategy
        PaymentStrategy paypalPayment = new PayPalPayment();
        paypalPayment.processPayment(onlineTotal);

        PaymentStrategy creditCardPayment = new CreditCardPayment();
        creditCardPayment.processPayment(inStoreTotal);
    }
}
