package com.ocheejeh.datastructures.projects.bank;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {
        transactions = new ArrayList<>();
        this.name = name;
        addTransaction(initialAmount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double amount){
        //autoboxing, jvm does this (i.e. Double.valueOf(x)) automatically if not stated explicitly
        transactions.add(Double.valueOf(amount));
    }

}
