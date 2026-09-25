package org.example.paymentTypes;

import org.example.interfaces.Payment;


public class BoletoPayment implements Payment {

    @Override
    public void pay(double amount) {

        if (amount >= 200) {
            amount += amount * 0.15;
        }

        System.out.println("Payment via Bank Slip");
        System.out.println("Total amount (taxes): $" + amount);
    }
}