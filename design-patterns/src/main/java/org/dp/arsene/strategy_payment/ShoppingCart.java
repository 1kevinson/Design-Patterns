package org.dp.arsene.strategy_payment;

import java.util.List;

public class ShoppingCart {

    private final List<Item> items;

    public ShoppingCart(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public int calculateTotalPrice() {
        return items.stream()
                .map(Item::getPrice)
                .reduce(0,Integer::sum);
    }

    public void pay(PaymentStrategy payment) {
        payment.pay(this.calculateTotalPrice());
    }
}
