package Abstract_Factory_Pattern;

// Abstract Factory for creating virtual pets
interface PetFactory {
    VirtualPet createPet();
    PetFood createFood();
}

// Abstract Product for virtual pets
interface VirtualPet {
    void interact();
}

// Abstract Product for pet food
interface PetFood {
    void feed(VirtualPet pet);
}

