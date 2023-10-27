package Abstract_Factory_Pattern;

// Concrete products
class Dog implements VirtualPet {
    @Override
    public void interact() {
        System.out.println("You played with the dog.");
    }
}

class Cat implements VirtualPet {
    @Override
    public void interact() {
        System.out.println("You petted the cat.");
    }
}

class Bird implements VirtualPet {
    @Override
    public void interact() {
        System.out.println("You fed the bird some seeds.");
    }
}

class DogFood implements PetFood {
    @Override
    public void feed(VirtualPet pet) {
        System.out.println("You fed the dog.");
        pet.interact();
    }
}

class CatFood implements PetFood {
    @Override
    public void feed(VirtualPet pet) {
        System.out.println("You gave the cat some tuna.");
        pet.interact();
    }
}

class BirdFood implements PetFood {
    @Override
    public void feed(VirtualPet pet) {
        System.out.println("You sprinkled some seeds for the bird.");
        pet.interact();
    }
}

