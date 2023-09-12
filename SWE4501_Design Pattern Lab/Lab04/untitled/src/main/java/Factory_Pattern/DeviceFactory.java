package Factory_Pattern;

// Step 3: Create a Factory Interface
public interface DeviceFactory {
    ElectronicDevice createDevice(String brand, String model);
}
