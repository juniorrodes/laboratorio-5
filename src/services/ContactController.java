package services;

import services.utils.Contact;

import java.util.HashMap;

public class ContactController {

    HashMap<String, Contact> contacts;

    public ContactController() {
        this.contacts = new HashMap<>();
    }

    public boolean insertNewContact(String contactNumber, Contact contact) {
        if (this.containContact(contactNumber)) {
            return false;
        }

        this.putContact(contactNumber, contact);

        return true;
    }

    public Contact replaceContact(String contactNumber, Contact contact) {
        return this.putContact(contactNumber, contact);
    }

    public Contact deleteContact(String contactNumber) {
        if(!this.containContact(contactNumber)) {
            return null;
        }

        return this.removeContact(contactNumber);
    }

    public boolean containContact(String contactNumber) {
        return this.contacts.containsKey(contactNumber);
    }

    private Contact putContact(String contactNumber, Contact contact) {
        return this.contacts.put(contactNumber, contact);
    }

    private Contact removeContact(String contactNumber) {
        return this.contacts.remove(contactNumber);
    }

    public Contact getContact(String contactNumber) {
        return this.contacts.get(contactNumber);
    }

}
