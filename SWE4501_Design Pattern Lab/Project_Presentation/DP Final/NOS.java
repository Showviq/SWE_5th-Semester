
// NOS (Nitrous Oxide System) decorator
class NOS extends Car {
    Car car;

    NOS(Car car) {
        this.car = car;
    }

    void applyNOS() {
        System.out.println("Applying NOS to the car...");
    }

    void carInfo() {
        car.carInfo();
        applyNOS();
    }
}