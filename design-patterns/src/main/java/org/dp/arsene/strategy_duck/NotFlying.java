package org.dp.arsene.strategy_duck;

public class NotFlying implements FlySkill {

    @Override
    public void fly() {
        System.out.println("Not flying at all");
    }
}
