import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

// Engine and Turbocharger behaviors
interface EngineBehavior {
    void engineInfo();
}

interface TurbochargerBehavior {
    void turbochargerInfo();
}

// Concrete engine implementations
class V6Engine implements EngineBehavior {
    public void engineInfo() {
        System.out.println("V6 Engine");
    }
}

class V8Engine implements EngineBehavior {
    public void engineInfo() {
        System.out.println("V8 Engine");
    }
}

class V12Engine implements EngineBehavior {
    public void engineInfo() {
        System.out.println("V12 Engine");
    }
}

// Concrete turbocharger implementations
class AlpineTurbocharger implements TurbochargerBehavior {
    public void turbochargerInfo() {
        System.out.println("Alpine Turbocharger");
    }
}

class CumminsTurbocharger implements TurbochargerBehavior {
    public void turbochargerInfo() {
        System.out.println("Cummins Turbocharger");
    }
}

class HoneywellTurbocharger implements TurbochargerBehavior {
    public void turbochargerInfo() {
        System.out.println("Honeywell Turbocharger");
    }
}

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

// Abstract Factory for cars
interface CarFactory {
    Car createCar();
}

class CoupeCarFactory implements CarFactory {
    public Car createCar() {
        EngineBehavior engineBehavior = new V6Engine();
        TurbochargerBehavior turbochargerBehavior = new AlpineTurbocharger();
        return new CoupeCar(engineBehavior, turbochargerBehavior);
    }
}

class RoadsterCarFactory implements CarFactory {
    public Car createCar() {
        EngineBehavior engineBehavior = new V8Engine();
        TurbochargerBehavior turbochargerBehavior = new CumminsTurbocharger();
        return new RoadsterCar(engineBehavior, turbochargerBehavior);
    }
}

// Track class
class Track {
    void trackInfo() {
        System.out.println("Track information...");
    }
}

// Factory for tracks
class TrackFactory {
    Track createTrack() {
        return new Track();
    }
}

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
/* Private constructor to prevent instantiation
        -----------------
                --------------
                        -------------
        */
// Race class with template pattern
class Race {
    final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    final Random random = new Random();

    final void race() {
        Car car = getPlayerCar();
        Track track = getSelectedTrack();
        // have to be done
        carInfo(car);
        trackInfo(track);
        // pattern
        startCar(car);
        startLine(track);
        accelerateCar(car);
        NOS nos = pitStop(car);
        applyNos(nos);
        finishLine(track);
        stopCar(nos);
        lapTime();
    }

    // These methods can be overridden by subclasses if needed
    void carInfo(Car car) {
        car.carInfo();
    }

    void trackInfo(Track track) {
        track.trackInfo();
    }

    void startCar(Car car) {
        car.start();
    }

    void startLine(Track track) {
        System.out.println("Starting at the race track...");
    }

    void accelerateCar(Car car) {
        car.accelerate();
    }

    NOS pitStop(Car car) {
        return new NOS(car);
    }

    void applyNos(NOS nos) {
        nos.accelerate(); // Applying NOS during acceleration
    }

    void finishLine(Track track) {
        System.out.println("Crossing the finish line...");
    }

    void stopCar(NOS nos) {
        nos.stop(); // Stopping the car with NOS
    }

    void lapTime() {
        System.out.println("Lap Time: " + sdf.format(random.nextInt(3600000)));
    }

    // Methods to get player choices
    Car getPlayerCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your car (1 for Coupe, 2 for Roadster): ");
        int choice = scanner.nextInt();

        CarFactory carFactory;
        if (choice == 1) {
            carFactory = new CoupeCarFactory();
        } else {
            carFactory = new RoadsterCarFactory();
        }

        return carFactory.createCar();
    }

    Track getSelectedTrack() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your track (1 for Blue Moon Bay, 2 for BB Raceway, 3 for Circuit de Spa-Francorchamps): ");
        int choice = scanner.nextInt();

        TrackFactory trackFactory = new TrackFactory();
        return trackFactory.createTrack();
    }
}

// Singleton Player class
class Player {
    private static Player instance;

    private Player() {
        /* Private constructor to prevent instantiation
        -----------------
                --------------
                        -------------
        */
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }
}

public class Main {
    public static void main(String[] args) {
        // Singleton instance of Player
        Player player = Player.getInstance();

        // Racing
        Race race = new Race();
        race.race();

        /*
        -----------------
                --------------
                        -------------
        */
    }
}
