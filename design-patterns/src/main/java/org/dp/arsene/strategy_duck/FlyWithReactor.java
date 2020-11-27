package org.dp.arsene.strategy_duck;

public class FlyWithReactor implements FlySkill{

    @Override
    public void fly() {
        System.out.println("Fly with reactor");
    }
}
