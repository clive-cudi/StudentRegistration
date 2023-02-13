package com.company;

import java.time.LocalDate;

public class Receipt extends FinanceDocument {
    private static String sender;
    private static String receiver;
    private static double transactionAmount;
    private static LocalDate paidOn;
    private static double receiptBalance;
    public Receipt(String senderName, String receiverName, double amountPaid, double balance) {
        super(sender, receiver, amountPaid);
        sender = senderName;
        receiver = receiverName;
        transactionAmount = amountPaid;
        paidOn = LocalDate.now();
        receiptBalance = balance;
    }

    public static void printReceipt() {
        System.out.println("\n****** RECEIPT ******\n");
        System.out.println("Sender: " + sender + "\nReceiver: " + receiver + "\nTransactionAmount: " + transactionAmount + "\nDate: " + paidOn.toString() + "\nBalance: " + receiptBalance);
        System.out.println("\n****** RECEIPT ******\n");
    }
}
