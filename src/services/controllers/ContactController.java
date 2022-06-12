package controllers;

import utils.ContactInfo;

import java.util.HashMap;


public class ContactController {

    HashMap<String, ContactInfo> contacts;

    public ContactController() {
        this.contacts = new HashMap<>();
    }

    public boolean insertNewContact(String contactNumber, ContactInfo contactInfo) {
        if (this.containContact(contactNumber)) {
            return false;
        }
        this.putContact(contactNumber, contactInfo);

        return true;
    }


    public void replaceContact(String contactNumber, ContactInfo contactInfo) {
        this.putContact(contactNumber, contactInfo);
    }

    public void deleteContact(String contactNumber) {
        if (!this.containContact(contactNumber)) {
            return;
        }

        this.removeContact(contactNumber);
    }

    public boolean containContact(String contactNumber) {
        return this.contacts.containsKey(contactNumber);
    }

    private void putContact(String contactNumber, ContactInfo contactInfo) {
        this.contacts.put(contactNumber, contactInfo);
    }

    private void removeContact(String contactNumber) {
        this.contacts.remove(contactNumber);
    }

    public ContactInfo getContact(String contactNumber) {
        return this.contacts.get(contactNumber);
    }

}
