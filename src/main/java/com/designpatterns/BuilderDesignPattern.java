package com.designpatterns;
 class House {
    private final String foundation;
    private final String structure;

    private final boolean hasSwimmingPool;
    private final boolean hasGarden;
    private final boolean hasGarage;

     House(HouseBuilder builder) {
        this.foundation = builder.getFoundation();
        this.structure = builder.getStructure();
        this.hasSwimmingPool = builder.hasSwimmingPool();
        this.hasGarden = builder.hasGarden();
        this.hasGarage = builder.hasGarage();
    }

    public String getFoundation() {
        return foundation;
    }

    public String getStructure() {
        return structure;
    }

    public boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }

    public boolean hasGarden() {
        return hasGarden;
    }

    public boolean hasGarage() {
        return hasGarage;
    }

    @Override
    public String toString() {
        return "House [foundation=" + foundation + ", structure=" + structure + ", hasSwimmingPool=" + hasSwimmingPool
                + ", hasGarden=" + hasGarden + ", hasGarage=" + hasGarage + "]";
    }
}



interface HouseBuilder {
    HouseBuilder setFoundation(String foundation);
    HouseBuilder setStructure(String structure);
    HouseBuilder setSwimmingPool(boolean hasSwimmingPool);
    HouseBuilder setGarden(boolean hasGarden);
    HouseBuilder setGarage(boolean hasGarage);
    House build();

    String getFoundation();
    String getStructure();
    boolean hasSwimmingPool();
    boolean hasGarden();
    boolean hasGarage();
}



 class ConcreteHouseBuilder implements HouseBuilder {
    private String foundation;
    private String structure;
    private boolean hasSwimmingPool;
    private boolean hasGarden;
    private boolean hasGarage;

    @Override
    public HouseBuilder setFoundation(String foundation) {
        this.foundation = foundation;
        return this;
    }

    @Override
    public HouseBuilder setStructure(String structure) {
        this.structure = structure;
        return this;
    }

    @Override
    public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
        this.hasSwimmingPool = hasSwimmingPool;
        return this;
    }

    @Override
    public HouseBuilder setGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
        return this;
    }

    @Override
    public HouseBuilder setGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
        return this;
    }

    @Override
    public House build() {
        return new House(this);
    }

    @Override
    public String getFoundation() {
        return foundation;
    }

    @Override
    public String getStructure() {
        return structure;
    }

    @Override
    public boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }

    @Override
    public boolean hasGarden() {
        return hasGarden;
    }

    @Override
    public boolean hasGarage() {
        return hasGarage;
    }
}


class HouseDirector {
    private HouseBuilder builder;

    public HouseDirector(HouseBuilder builder) {
        this.builder = builder;
    }

    public House constructLuxuryHouse() {
        return builder
                .setFoundation("Concrete")
                .setStructure("Brick")
                .setSwimmingPool(true)
                .setGarden(true)
                .setGarage(true)
                .build();
    }

    public House constructSimpleHouse() {
        return builder
                .setFoundation("Concrete")
                .setStructure("Wood")
                .setSwimmingPool(false)
                .setGarden(false)
                .setGarage(false)
                .build();
    }
}




public class BuilderDesignPattern {
    public static void main(String[] args) {
        HouseBuilder builder = new ConcreteHouseBuilder();

        HouseDirector director = new HouseDirector(builder);

        House simpleHouse = director.constructSimpleHouse();
        System.out.println(simpleHouse);

        House luxuryHouse = director.constructLuxuryHouse();
        System.out.println(luxuryHouse);
    }
}
