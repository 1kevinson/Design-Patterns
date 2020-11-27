package org.dp.arsene.strategy_duck;

public class Colvert extends Duck {

    public Colvert() {
        quackSkill = new QuackQuack();
        flySkill = new FlyWithWings();
    }

    @Override
    public void show() {
        System.out.println("I am a  Colvert");
    }
}
