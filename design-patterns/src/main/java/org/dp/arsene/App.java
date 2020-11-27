package org.dp.arsene;

import org.dp.arsene.strategy_duck.Colvert;
import org.dp.arsene.strategy_duck.Duck;
import org.dp.arsene.strategy_duck.DuckPrototype;
import org.dp.arsene.strategy_duck.FlyWithReactor;

/**
 * Strategy Pattern exemple for Duck
 */
public class App 
{
    public static void main( String[] args )
    {
        Duck colvert = new Colvert();
        colvert.doQuack();
        colvert.doFly();
        colvert.swim();
        colvert.show();
        System.out.println("------------------");

        Duck prototype = new DuckPrototype();
        prototype.doFly();
        prototype.setFlySkill(new FlyWithReactor());
        prototype.doFly();
    }
}
