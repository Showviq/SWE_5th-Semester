package Factory_Pattern;

public class LaptopFactory implements DeviceFactory {
    @Override
    public ElectronicDevice createDevice(String brand, String model) {
        return new Laptop(brand, model);
    }
}
