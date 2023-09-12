package Factory_Pattern;

// Step 2: Create Concrete Products
public class Smartphone extends ElectronicDevice {
    public Smartphone(String brand, String model) {
        super(brand, model);
    }

    @Override
    public String displayInfo() {
        return "Smartphone: " + brand + " " + model;
    }
}
