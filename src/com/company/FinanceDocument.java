package com.company;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class FinanceDocument {
    private static int documentNumber;
    private static String documentID;
    private static LocalDate date;
    private static double amount;
    private static String sourceName;
    private static String recepientName;

    public FinanceDocument(String sender, String receiver, double transactionAmount) {
        documentID = UUID.randomUUID().toString();
        date = LocalDate.now();
        sourceName = sender;
        recepientName = receiver;
        amount = transactionAmount;
    }
}
