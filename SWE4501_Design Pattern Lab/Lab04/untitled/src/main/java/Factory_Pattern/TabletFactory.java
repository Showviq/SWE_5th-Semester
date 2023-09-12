package Factory_Pattern;

public class TabletFactory implements DeviceFactory {
    @Override
    public ElectronicDevice createDevice(String brand, String model) {
        return new Tablet(brand, model);
    }
}
