package com.example.contact.contact;

import com.example.contact.contact.Contact;
import com.example.contact.contact.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactRepositoryImpl implements ContactRepository {
//    final ArrayList<Contact> virtualDB = new ArrayList<>();
    @Autowired
    private Contacts contacts;
    @Override
    public List<Contact> findAll() {
        return contacts.findAll();
    }

    @Override
    public void save(Contact contact) {contacts.save(contact);}

    @Override
    public void clear() {
        contacts.clear();
    }
}
