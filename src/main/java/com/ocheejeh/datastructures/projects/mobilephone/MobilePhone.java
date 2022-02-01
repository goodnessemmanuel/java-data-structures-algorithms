package com.ocheejeh.datastructures.projects.mobilephone;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber) {
        myContacts = new ArrayList<>();
        this.myNumber = myNumber;
    }

    public boolean addNewContact(Contact contact){
        if(null != contact && findContact(contact) == -1) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int contactIndex = findContact(oldContact);
        if(contactIndex == -1 || null == newContact) return false;
        myContacts.set(contactIndex, newContact);
        return true;
    }

    public boolean removeContact(Contact contactToRemove){
        if(findContact(contactToRemove)  >= 0) {
           return myContacts.remove(contactToRemove);
        }
        return false;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    private int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }

    public int findContact(String nameOrPhone){
        Contact queryContact = queryContact(nameOrPhone);
        if(queryContact == null)
            return -1;

        return findContact(queryContact);

    }

    public Contact queryContact(String nameOrPhone){
        for (Contact contact: myContacts) {
            if(contact.getName().equalsIgnoreCase(nameOrPhone) ||
                    contact.getPhoneNumber().equalsIgnoreCase(nameOrPhone)){
                return contact;
            }
        }
        return null;
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.printf("%d. %s -> %s%n", i + 1, contact.getName(), contact.getPhoneNumber());
        }
    }
}
