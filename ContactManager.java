package com.contacts.manage;

import java.util.ArrayList;

public class ContactManager {
    ArrayList<Contacts> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<Contacts>();
    }

    public Contacts getContact(int index) {
        return new Contacts(contacts.get(index));
    }

    public void setContact(Contacts contact, int index) {
        contacts.set(index, new Contacts(contact));
    }

    public void addContact(Contacts contact) {
        contacts.add(new Contacts(contact));
    }

    public void removeContact(String name) {
        if (contacts.isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        }
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                contacts.remove(i);
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < contacts.size(); i++) {
            temp += contacts.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }

}
