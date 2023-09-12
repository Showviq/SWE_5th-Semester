package Factory_Pattern;

// Step 4: Create Concrete Factories
public class SmartphoneFactory implements DeviceFactory {
    @Override
    public ElectronicDevice createDevice(String brand, String model) {
        return new Smartphone(brand, model);
    }
}
