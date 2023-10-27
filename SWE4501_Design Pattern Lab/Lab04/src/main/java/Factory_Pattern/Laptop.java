package Factory_Pattern;

public class Laptop extends ElectronicDevice {
    public Laptop(String brand, String model) {
        super(brand, model);
    }

    @Override
    public String displayInfo() {
        return "Laptop: " + brand + " " + model;
    }
}
