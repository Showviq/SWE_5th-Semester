public class ToppingDecorator extends FoodItem {
    private FoodItem foodItem;

    public ToppingDecorator(FoodItem foodItem, String toppingName, double toppingPrice) {
        super(foodItem.name + " with " + toppingName, foodItem.price + toppingPrice);
        this.foodItem = foodItem;
    }
}
