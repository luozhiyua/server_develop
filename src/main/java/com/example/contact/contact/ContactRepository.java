package com.example.contact.contact;

import com.example.contact.contact.Contact;

import java.util.List;

public interface ContactRepository {
    List<Contact> findAll();

    void save(Contact contact);

    void clear();
}
