package org.dp.arsene.strategy_payment;

import java.time.LocalDate;
import java.util.List;

class Item {

    private final String upcCode;
    private final String name;
    private final String description;
    private final Integer price;

    public Item(String upcCode, String name, String description, Integer price) {
        this.upcCode = upcCode;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }
}

class ShoppingCart {

    private final List<Item> items;

    public ShoppingCart(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public int calculateTotalPrice() {
        return items.stream()
                .map(Item::getPrice)
                .reduce(0, Integer::sum);
    }

    public void pay(PaymentStrategy payment) {
        payment.pay(this.calculateTotalPrice());
    }
}

interface PaymentStrategy {
    void pay(int price);
}

class CreditCardStrategy implements PaymentStrategy {

    private final String name;
    private final String cardNumber;
    private final String cvv;
    private final LocalDate dateOfExpiry;

    public CreditCardStrategy(String name, String cardNumber, String cvv, LocalDate dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    @Override
    public void pay(int totalPrice) {
        System.out.println("Credit card pays " + totalPrice + " € by " + this.name + " with card N° : " + this.cardNumber);
    }

}

class PaypalStrategy implements PaymentStrategy {

    private final String email;
    private final String password;

    public PaypalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void pay(int totalPrice) {
        System.out.println("PayPal pays " + totalPrice + " € by the user with this email => " + this.email);
    }
}

public class StrategyCard {

    public static void main(String[] args) {
        final var cartItems = List.of(
                new Item("HD45DDF455", "iPad Pro", "apple tablet", 600),
                new Item("HD45D44455", "airPod Pro", "apple earphone", 250),
                new Item("HD45DSX455", "MackBook Pro 16", "apple laptop", 2600)
        );

        final ShoppingCart cart = new ShoppingCart(cartItems);

        cart.pay(new CreditCardStrategy("Revolut","2245 2558 6965 1458","854",LocalDate.of(2022,5,14)));
    }
}