package com.company;

import java.time.LocalDate;

public class Invoice extends FinanceDocument{
    public Invoice(String sender, String receiver, double amount, LocalDate dueDate) {
        super(sender, receiver, amount);
    }

    public static void printInvoice() {
        System.out.println("");
    }
}
