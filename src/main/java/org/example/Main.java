package org.example;

import org.example.paymentTypes.BoletoPayment;
import org.example.paymentTypes.CardPayment;
import org.example.paymentTypes.PixPayment;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CheckoutService checkout = new CheckoutService();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== MINI CHECKOUT ===");
            System.out.println("1. PIX");
            System.out.println("2. Credit Card");
            System.out.println("3. Bank Slip");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int option = sc.nextInt();

            if (option == 0) {
                System.out.println("Exiting...");
                break;
            }

            switch (option) {

                case 1:
                    checkout.setPayment(new PixPayment());
                    break;

                case 2:
                    checkout.setPayment(new CardPayment());
                    break;

                case 3:
                    checkout.setPayment(new BoletoPayment());
                    break;

                default:
                    System.out.println("Invalid option!");
                    continue;
            }

            System.out.print("Enter the amount: $");
            double amount = sc.nextDouble();

            checkout.checkout(amount);
        }

        sc.close();
    }
}