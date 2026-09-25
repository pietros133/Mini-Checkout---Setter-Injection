package org.example;

import org.example.interfaces.Payment;
public class CheckoutService {

    private Payment payment;

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void checkout(double amount) {
        payment.pay(amount);
    }
}