package org.dp.arsene.strategy_duck;

public class DuckPrototype extends Duck {

    public DuckPrototype() {
        flySkill = new NotFlying();
        quackSkill = new QuackQuack();
    }

    @Override
    public void show() {
        System.out.println("I'm a prototype of duck");
    }
}
