package com.company;

import java.time.LocalDate;

public class Accountant extends Person {
    public Accountant() {

    }
    public Accountant(String name) {
          super(name);
    }
    public static void receiptFeePayment(double amount, String studentName, double balance) {
        System.out.println("Generating receipt for fee payment...");

        Receipt receipt = new Receipt("School", studentName, amount, balance);
        receipt.printReceipt();
    }

    public static void invoiceFeePayment(double amount, String studentName, LocalDate dueDate) {
        System.out.println("Generating invoice for fee payment...");

        Invoice invoice = new Invoice("School", studentName, amount, dueDate);
        invoice.printInvoice();
    }

    public static void confirmStudentRegistration(Student student) {
        student.verify();

        System.out.println("Verified " + student.getName());
    }
}
