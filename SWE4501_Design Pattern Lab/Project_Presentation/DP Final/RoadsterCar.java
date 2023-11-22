
class RoadsterCar extends Car {
    RoadsterCar(EngineBehavior engineBehavior, TurbochargerBehavior turbochargerBehavior) {
        this.engineBehavior = engineBehavior;
        this.turbochargerBehavior = turbochargerBehavior;
    }

    void carInfo() {
        System.out.println("Roadster Car:");
        engineBehavior.engineInfo();
        turbochargerBehavior.turbochargerInfo();
    }
}