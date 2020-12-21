package org.dp.arsene.factory;

/**
 * Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.
 */
public class AbstractFactory {

    public static void main(String[] args) {

        String gender = "Female";
        final Client client = switch (gender) {
            case "Male" -> new Client(new VictorianFurnitureFactory());
            case "Female" -> new Client(new ModernFurnitureFactory());
            default -> throw new IllegalStateException("Unexpected Furniture Value: " + null);
        };

        System.out.println(client.getChair());
    }
}

// STEP 1 - Declare interface for each distinct product of a product family
interface Chair {
    void hasLegs();

    void sitOn();
}

interface Sofa {
    void isCosy();
}

interface CoffeeTable {
    void canTakeACoffeeOn();
}


// STEP 2 - Call variant products to follow interfaces
class ArtDecoChair implements Chair {

    @Override
    public void hasLegs() {

    }

    @Override
    public void sitOn() {

    }
}

class VictorianChair implements Chair {
    @Override
    public void hasLegs() {

    }

    @Override
    public void sitOn() {

    }
}

class ModernChair implements Chair {
    @Override
    public void hasLegs() {

    }

    @Override
    public void sitOn() {

    }
}

class ArtDecoCoffeeTable implements CoffeeTable {
    @Override
    public void canTakeACoffeeOn() {

    }
}

class VictorianCoffeeTable implements CoffeeTable {
    @Override
    public void canTakeACoffeeOn() {

    }
}

class ModernCoffeeTable implements CoffeeTable {
    @Override
    public void canTakeACoffeeOn() {

    }
}

class ArtDecoSofa implements Sofa {
    @Override
    public void isCosy() {

    }
}

class VictorianSofa implements Sofa {
    @Override
    public void isCosy() {

    }
}

class ModernSofa implements Sofa {
    @Override
    public void isCosy() {

    }
}


// STEP 3 - Declare the Abstract Factory
interface AbsFactory {

    Chair createChair();

    CoffeeTable createCoffeeTable();

    Sofa createSofa();
}


// STEP 4 - Create for each product family a factory class
class VictorianFurnitureFactory implements AbsFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}

class ModernFurnitureFactory implements AbsFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }

    @Override
    public Sofa createSofa() {
        return null;
    }
}


// STEP 5 - Client class for tests
class Client {
    private final AbsFactory factory;

    Client(AbsFactory factory) {
        this.factory = factory;
    }

    Chair getChair() {
        return factory.createChair();
    }
}