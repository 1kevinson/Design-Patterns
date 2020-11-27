package org.dp.arsene.strategy_duck;

public class MuteDuck implements QuackSkill {

    @Override
    public void quack() {
        System.out.println("Not sound...");
    }
}
