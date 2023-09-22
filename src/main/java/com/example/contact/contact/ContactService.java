package com.example.contact.contact;

import com.example.contact.contact.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAll();

    void add(Contact contact);
}
