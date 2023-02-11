package com.company;

public class Receipt extends FinanceDocument {
    public Receipt(String sender, String receiver, double amountPaid) {
        super(sender, receiver, amountPaid);
    }

    public static void printReceipt() {
        System.out.println("");
    }
}
