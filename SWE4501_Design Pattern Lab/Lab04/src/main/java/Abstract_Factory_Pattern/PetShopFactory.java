package Abstract_Factory_Pattern;

// Concrete factories
class PetShopFactory implements PetFactory {
    @Override
    public VirtualPet createPet() {
        return new Dog();
    }

    @Override
    public PetFood createFood() {
        return new DogFood();
    }
}

class CatCafeFactory implements PetFactory {
    @Override
    public VirtualPet createPet() {
        return new Cat();
    }

    @Override
    public PetFood createFood() {
        return new CatFood();
    }
}

class BirdAviaryFactory implements PetFactory {
    @Override
    public VirtualPet createPet() {
        return new Bird();
    }

    @Override
    public PetFood createFood() {
        return new BirdFood();
    }
}

