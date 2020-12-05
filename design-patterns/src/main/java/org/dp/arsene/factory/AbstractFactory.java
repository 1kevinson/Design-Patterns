package org.dp.arsene.factory;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AbstractFactory {
}

interface HotDrink {
    void consume();
}

class Tea implements HotDrink {

    @Override
    public void consume() {
        System.out.println("This tea is delicious");
    }
}

class Coffee implements HotDrink {

    @Override
    public void consume() {
        System.out.println("This coffee is delicious");
    }
}

interface HotDrinkFactory {
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory {

    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Put in tea bag, boil water, pour " + amount + " ml, add lemon, enjoy!");
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory {

    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Grind some beans, boil water,  pour " + amount + "ml, add cream, enjoy!");
        return new Coffee();
    }
}
