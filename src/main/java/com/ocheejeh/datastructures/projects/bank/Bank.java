package com.ocheejeh.datastructures.projects.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction){
        for (Branch branch: branches) {
            if(branchName.equalsIgnoreCase(branch.getName())){
              return  branch.newCustomer(customerName, initialTransaction);
            }
        }

        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        for (Branch branch: branches) {
            if(branchName.equalsIgnoreCase(branch.getName())){
                return branch.addCustomerTransaction(customerName, amount);
            }

        }
        return false;
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName) == null){
            System.out.println("Adding a new bank branch...");
            branches.add(new Branch(branchName));
            return true;
        }
        System.out.println("Bank branch already exists");
        return false;
    }

    public boolean listCustomers(String branchName, boolean printTransaction){
        Branch branch = findBranch(branchName);
        if(branch == null) return false;
        System.out.println("Customer details for branch " + branch.getName());
        List<Customer> customers = branch.getCustomers();
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.println("Customer: " + customer.getName() + "[" + (i + 1) + "]");
            if(printTransaction){
                System.out.println("Transactions");
                List<Double> transactions = customer.getTransactions();
                for (int j = 0; j < transactions.size(); j++) {
                    //unboxing i.e. var<Double>.doubleValue()
                    System.out.println("[" + (j + 1) + "] " + " Amount " + transactions.get(j).doubleValue());
                }
            }

        }
        return true;
    }


    private Branch findBranch(String branchName) {
        for (Branch branch: branches) {
            if(branchName.equalsIgnoreCase(branch.getName()))
                return branch;
        }
        return null;
    }
}
