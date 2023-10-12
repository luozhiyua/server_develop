package com.example.contact.controller;

import com.example.contact.contact.Contact;
import com.example.contact.data.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.validation.Errors;

@Controller
@RequestMapping("/contact")
public class ContactController {
    private final ContactRepository contactRepository;
    @Autowired
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @ModelAttribute(name = "contact")
    public Contact contact(){
        return new Contact();
    }

    @ModelAttribute(name = "contacts")
    public Iterable<Contact> contacts(){
        return contactRepository.findAll();
    }

    @GetMapping
    public String showContactForm(){
        return "contact";
    }

    @PostMapping
    public String processContact(
            @Valid Contact contact, Errors errors
    ){
        if(errors.hasErrors())return "contact";
        contactRepository.save(contact);
        return "redirect:/contact";
    }

}
