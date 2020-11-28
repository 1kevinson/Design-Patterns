package org.dp.arsene.strategy_payment;

import java.time.LocalDate;

public class CreditCardStrategy implements PaymentStrategy {

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
