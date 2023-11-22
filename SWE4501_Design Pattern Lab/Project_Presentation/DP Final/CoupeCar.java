
class CoupeCar extends Car {
    CoupeCar(EngineBehavior engineBehavior, TurbochargerBehavior turbochargerBehavior) {
        this.engineBehavior = engineBehavior;
        this.turbochargerBehavior = turbochargerBehavior;
    }

    void carInfo() {
        System.out.println("Coupe Car:");
        engineBehavior.engineInfo();
        turbochargerBehavior.turbochargerInfo();
    }
}