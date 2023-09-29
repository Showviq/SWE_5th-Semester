import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    protected List<String> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        this.items.add(item);
    }

    public abstract double calculateTotal();
}
