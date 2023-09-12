package Abstract_Factory_Pattern;

public class Main {
    public static void playWithPet(PetFactory petFactory) {
        VirtualPet pet = petFactory.createPet();
        PetFood food = petFactory.createFood();

        pet.interact();
        food.feed(pet);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Virtual Pet Game!");

        // Choose a pet shop
        PetFactory petShop = new PetShopFactory();
        playWithPet(petShop);

        // Choose a cat cafe
        PetFactory catCafe = new CatCafeFactory();
        playWithPet(catCafe);

        // Choose a bird aviary
        PetFactory birdAviary = new BirdAviaryFactory();
        playWithPet(birdAviary);
    }
}

