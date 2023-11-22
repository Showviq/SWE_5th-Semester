
/* Private constructor to prevent instantiation
        -----------------
                --------------
                        -------------
        */
// Race class with template pattern

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

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