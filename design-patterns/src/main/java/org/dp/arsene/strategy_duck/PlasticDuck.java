package org.dp.arsene.strategy_duck;

public class PlasticDuck extends Duck{

    public PlasticDuck() {
        flySkill = new NotFlying();
        quackSkill = new QuackQuack();
    }

    @Override
    public void show() {
        System.out.println("I am a false duck (in plastic).");
    }
}
