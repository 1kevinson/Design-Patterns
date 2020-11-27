package org.dp.arsene.strategy_duck;

public class FlyWithWings implements FlySkill{

    @Override
    public void fly() {
        System.out.println("Fly with wings");
    }
}
