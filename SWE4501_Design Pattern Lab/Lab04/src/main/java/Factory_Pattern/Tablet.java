package Factory_Pattern;

public class Tablet extends ElectronicDevice {
    public Tablet(String brand, String model) {
        super(brand, model);
    }

    @Override
    public String displayInfo() {
        return "Tablet: " + brand + " " + model;
    }
}
