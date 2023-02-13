package com.company;

import java.time.LocalDate;

public class Invoice extends FinanceDocument{
    private static String sender;
    private static String receiver;
    private static double transactionAmount;
    private static LocalDate dateDue;
    public Invoice(String senderName, String receiverName, double amount, LocalDate dueDate) {
        super(senderName, receiverName, amount);
        sender = senderName;
        receiver = receiverName;
        transactionAmount = amount;
        dateDue = dueDate;
    }

    public static void printInvoice() {
        System.out.println("\n****** INVOICE ******\n");
        System.out.println("Sender: "+ sender + "\nReceiver: " + receiver + "\nTransaction Amount: " + transactionAmount + "\nExpires on: " + dateDue.toString());
        System.out.println("\n****** INVOICE ******\n");
    }
}
