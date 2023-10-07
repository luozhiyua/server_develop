package com.example.contact.contact;

import com.example.contact.contact.Contact;
import com.example.contact.contact.ContactRepository;
import com.example.contact.contact.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

//    public ContactServiceImpl(ContactRepository contactRepository){
//        this.contactRepository = contactRepository;
//    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public void add(Contact contact) {
        contactRepository.save(contact);
    }
}
