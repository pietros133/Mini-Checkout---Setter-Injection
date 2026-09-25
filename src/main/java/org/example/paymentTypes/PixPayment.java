package org.example.paymentTypes;

import org.example.interfaces.Payment;
public class PixPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Payment via PIX");
        System.out.println("Amount: $" + amount);
    }
}