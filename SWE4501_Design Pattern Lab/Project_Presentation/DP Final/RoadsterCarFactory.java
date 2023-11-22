
class RoadsterCarFactory implements CarFactory {
    public Car createCar() {
        EngineBehavior engineBehavior = new V8Engine();
        TurbochargerBehavior turbochargerBehavior = new CumminsTurbocharger();
        return new RoadsterCar(engineBehavior, turbochargerBehavior);
    }
}