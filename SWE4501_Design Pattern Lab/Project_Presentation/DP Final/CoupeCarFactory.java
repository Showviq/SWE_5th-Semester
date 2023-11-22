
class CoupeCarFactory implements CarFactory {
    public Car createCar() {
        EngineBehavior engineBehavior = new V6Engine();
        TurbochargerBehavior turbochargerBehavior = new AlpineTurbocharger();
        return new CoupeCar(engineBehavior, turbochargerBehavior);
    }
}