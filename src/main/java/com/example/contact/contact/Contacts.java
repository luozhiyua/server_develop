package com.example.contact.contact;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Contacts {
    final ArrayList<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }
    public List<Contact> findAll() {
        return contacts;
    }

    public void save(Contact contact) {
        contacts.add(contact);
    }

    public void clear() {
        contacts.clear();
    }

}
