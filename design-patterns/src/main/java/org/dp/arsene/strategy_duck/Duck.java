package org.dp.arsene.strategy_duck;

public abstract class Duck {

    protected FlySkill flySkill;
    protected QuackSkill quackSkill;

    public void doFly(){
        flySkill.fly();
    }

    public void doQuack(){
        quackSkill.quack();
    }

    public void swim() {
        System.out.println("I'm a duck so i can swim");
    }

    abstract public void show();

    public void setFlySkill(FlySkill flySkill) {
        this.flySkill = flySkill;
    }

    public void setQuackSkill(QuackSkill quackSkill) {
        this.quackSkill = quackSkill;
    }
}
