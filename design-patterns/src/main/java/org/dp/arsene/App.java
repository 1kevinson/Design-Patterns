package org.dp.arsene;

import org.dp.arsene.strategy_payment.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Strategy Pattern exemple for Duck
 */
public class App {
    public static void main(String[] args) {

        System.out.println("//  SHOPPING STRATEGY  //\n");

        final var items = new ArrayList<>(List.of(
                new Item("DEG44515EE4", "AirPods Pro", "wireless earphones by apple", 270),
                new Item("DEG4XQXD778", "Ipad Pro", "Tablet by apple", 670)
        ));

        final var cart = new ShoppingCart(items);
        cart.pay(new CreditCardStrategy("Arsene", "4151 2598 4756 6633", "854", LocalDate.now()));

        cart.addItem(new Item("DS9985SAZZ", "Magic KeyBoard", "keyboard apple", 130));
        cart.pay(new PaypalStrategy("kakarot@hippy.fr", "$dif4787984/d4f"));

        System.out.print("\n/  END  /");
    }
}
