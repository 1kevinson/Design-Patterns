package org.dp.arsene.strategy_duck;

public class QuackQuack implements QuackSkill {
    @Override
    public void quack() {
        System.out.println("Quack Quack !!!");
    }
}
