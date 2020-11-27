package org.dp.arsene;

import org.dp.arsene.strategy_duck.Colvert;
import org.dp.arsene.strategy_duck.Duck;

/**
 * Hello world!
 *
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
    }
}
