package org.dp.arsene.strategy_duck;

public abstract class Duck {

    protected FlySkill flySkill;
    protected QuackSkill quackSkill;

    protected void doFly(){
        flySkill.fly();
    }

    protected void doQuack(){
        quackSkill.quack();
    }

    protected void swim() {
        System.out.println("I'm a duck so i can swim");
    }

    abstract protected void show();
}
