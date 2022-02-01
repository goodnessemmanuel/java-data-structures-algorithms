package com.ocheejeh.datastructures.projects.mobilephone;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MobilePhoneTest {
    MobilePhone mobilePhone;

    @BeforeEach
    void init(){
        mobilePhone = new MobilePhone("08065435423");
    }

    @Test
    @DisplayName("Should correctly add new contacts")
    void shouldAddNewContact(){
        Contact contact = Contact.createContact("John", "09087453267");

//        assertAll(
//                () -> assertTrue(mobilePhone.addNewContact(contact)),
//                () -> assertFalse(mobilePhone.addNewContact(null)) //does not allow null value
//        );

        Contact contact1 = Contact.createContact("John", "09087453267");
        assertTrue(mobilePhone.addNewContact(contact));
        assertTrue(mobilePhone.addNewContact(contact1));

    }

    @Test
    public void shouldUpdateContact(){
        Contact  oldContact = Contact.createContact("John", "09087453267");
        mobilePhone.addNewContact(oldContact);

        Contact newContact = new Contact(oldContact.getName(), "000000000");
        boolean updateContactStatus = mobilePhone.updateContact(oldContact, newContact);

        assertAll(
                () -> assertTrue(updateContactStatus),
                () -> assertTrue(mobilePhone.getMyContacts().contains(newContact)), //list should contain updated contact
                () -> assertFalse(mobilePhone.getMyContacts().contains(oldContact)) //old contact no longer exists
        );

    }

    @Test
    public void shouldDeleteContact(){
        Contact  contact = Contact.createContact("John", "09087453267");
        mobilePhone.addNewContact(contact);
        assertTrue(mobilePhone.getMyContacts().size() > 0);

        boolean removeContactStatus = mobilePhone.removeContact(contact);
        assertAll(
                () -> assertTrue(removeContactStatus),
                () -> assertFalse(mobilePhone.getMyContacts().contains(contact)) //list should contain updated contact
        );

    }

    @Test
    public void shouldFindContact(){
        Contact  contact = Contact.createContact("John", "09087453267");
        mobilePhone.addNewContact(contact);

        int index = mobilePhone.findContact("John");

        assertEquals(index, mobilePhone.getMyContacts().indexOf(contact));
    }

    @Test
    @DisplayName("Should return the contact been queried")
    public void shouldQueryContact(){
        Contact  johnContact = Contact.createContact("John", "09087453267");
        Contact  jimContact = Contact.createContact("Jim", "06034101723");
        mobilePhone.addNewContact(johnContact);
        mobilePhone.addNewContact(jimContact);

        Contact queryJimContact = mobilePhone.queryContact("Jim");
        Contact queryJohnContact = mobilePhone.queryContact("john");

        assertAll(
                () -> assertEquals(queryJimContact, jimContact, "Should return contact associated with the parameter"),
                () -> assertEquals(queryJohnContact, johnContact, "Should return contact associated with the parameter")

        );
    }

    @Test
    public void shouldPrintAllContact(){
        Contact  johnContact = Contact.createContact("John", "09087453267");
        Contact  jimContact = Contact.createContact("Jim", "06034101723");
        mobilePhone.addNewContact(johnContact);
        mobilePhone.addNewContact(jimContact);
        mobilePhone.printContacts();
    }

}