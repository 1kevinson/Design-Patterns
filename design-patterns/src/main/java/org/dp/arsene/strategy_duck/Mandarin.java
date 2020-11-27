package org.dp.arsene.strategy_duck;

public class Mandarin extends Duck {

    public Mandarin() {
        flySkill = new FlyWithWings();
        quackSkill = new QuackQuack();
    }

    @Override
    public void show() {
        System.out.println("I'm a Mandarin");
    }
}
