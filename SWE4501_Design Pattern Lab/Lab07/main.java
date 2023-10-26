
interface VillageComponent {
    void showDetails();
}


class House implements VillageComponent {
    private String type;

    public House(String type) {
        this.type = type;
    }

    @Override
    public void showDetails() {
        System.out.println("This is a " + type + " house.");
    }
}

class Tree implements VillageComponent {
    private String type;

    public Tree(String type) {
        this.type = type;
    }

    @Override
    public void showDetails() {
        System.out.println("This is a " + type + " tree.");
    }
}

class WaterSource implements VillageComponent {
    private String type;

    public WaterSource(String type) {
        this.type = type;
    }

    @Override
    public void showDetails() {
        System.out.println("This is a " + type + " water source.");
    }
}


class VillageBuilder {
    private House house;
    private Tree tree;
    private WaterSource waterSource;

    public VillageBuilder buildHouse(String type) {
        this.house = new House(type);
        return this;
    }

    public VillageBuilder buildTree(String type) {
        this.tree = new Tree(type);
        return this;
    }

    public VillageBuilder buildWaterSource(String type) {
        this.waterSource = new WaterSource(type);
        return this;
    }

    public void showVillage() {
        if (house != null) {
            house.showDetails();
        }
        if (tree != null) {
            tree.showDetails();
        }
        if (waterSource != null) {
            waterSource.showDetails();
        }
    }
}


public class AoVGame {
    public static void main(String[] args) {
        VillageBuilder builder = new VillageBuilder();
        builder.buildHouse("Brick")
                .buildTree("Mango")
                .buildWaterSource("Swimming Pool")
                .showVillage();

        
        builder.buildHouse("Mud")
                .buildTree("Banana")
                .buildWaterSource("Pond")
                .showVillage();
    }
}
