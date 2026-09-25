package org.example.paymentTypes;

import org.example.interfaces.Payment;

public class CardPayment implements Payment {

    @Override
    public void pay(double amount) {

        if (amount >= 200) {
            amount += amount * 0.15;
        }

        System.out.println("Payment via Credit Card");
        System.out.println("Total amount(taxes): $" + amount);
    }
}