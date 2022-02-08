package com.ocheejeh.datastructures.projects.bank;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialAmount){
        if(findCustomer(customerName) == null){
            customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount){
        Customer customer = findCustomer(customerName);
        if(customer == null) return false;
        System.out.println("Adding transaction for " + customerName);
        customer.addTransaction(amount);
        return true;
    }

    private Customer findCustomer(String customerName) {
        for (Customer customer: customers) {
            if(customerName.equalsIgnoreCase(customer.getName()))
                return customer;
        }
        return null;
    }
}
