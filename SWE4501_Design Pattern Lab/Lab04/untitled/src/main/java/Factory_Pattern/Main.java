package Factory_Pattern;

// Client code
public class Main {
    public static void orderDevice(DeviceFactory factory, String brand, String model) {
        ElectronicDevice device = factory.createDevice(brand, model);
        System.out.println("Ordered " + device.displayInfo());
    }

    public static void main(String[] args) {
        DeviceFactory smartphoneFactory = new SmartphoneFactory();
        DeviceFactory laptopFactory = new LaptopFactory();
        DeviceFactory tabletFactory = new TabletFactory();

        orderDevice(smartphoneFactory, "Samsung", "Galaxy S21");
        orderDevice(laptopFactory, "Dell", "XPS 13");
        orderDevice(tabletFactory, "Apple", "iPad Pro");
    }
}
