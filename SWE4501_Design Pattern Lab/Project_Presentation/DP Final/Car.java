
// Car class with strategy pattern
abstract class Car {
    EngineBehavior engineBehavior;
    TurbochargerBehavior turbochargerBehavior;

    void start() {
        System.out.println("Car starting...");
    }

    void stop() {
        System.out.println("Car stopping...");
    }

    void accelerate() {
        System.out.println("Car accelerating...");
    }

    abstract void carInfo();
}