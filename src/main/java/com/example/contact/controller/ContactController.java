package com.example.contact.controller;

import com.example.contact.contact.Contact;
import com.example.contact.contact.Contacts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.validation.Errors;

@Controller
@RequestMapping("/contact")
@SessionAttributes("contacts")
public class ContactController {
    @ModelAttribute(name = "contact")
    public Contact contact(){
        return new Contact();
    }

    @ModelAttribute(name = "contacts")
    public Contacts contacts(){
        return new Contacts();
    }

    @GetMapping
    public String showContactForm(){
        return "contact";
    }

    @PostMapping
    public String processContact(
            @Valid Contact contact, Errors errors,
            @ModelAttribute Contacts contacts
    ){
        if(errors.hasErrors())return "contact";
        contacts.save(contact);
        return "contact";
    }

}
