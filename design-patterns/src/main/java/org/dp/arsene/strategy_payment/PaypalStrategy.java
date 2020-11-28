package org.dp.arsene.strategy_payment;

public class PaypalStrategy implements PaymentStrategy {

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
