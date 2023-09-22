package com.example.contact.contact;

import com.example.contact.contact.Contact;
import com.example.contact.contact.ContactRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactRepositoryImpl implements ContactRepository {
    final ArrayList<Contact> virtualDB = new ArrayList<>();
    @Override
    public List<Contact> findAll() {
        return virtualDB;
    }

    @Override
    public void save(Contact contact) {
        virtualDB.add(contact);
    }

    @Override
    public void clear() {
        virtualDB.clear();
    }
}
