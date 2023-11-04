package com.example.contact.controller;

import com.example.contact.contact.Contact;
import com.example.contact.data.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.validation.Errors;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ContactController {
    private final ContactRepository contactRepository;
    @Autowired
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

//    @ModelAttribute(name = "contact")
//    public Contact contact(){
//        return new Contact();
//    }
//
//    @ModelAttribute(name = "contacts")
//    public Iterable<Contact> contacts(){
//        return contactRepository.findAll();
//    }
//@PostMapping
//public String processContact(
//        @Valid Contact contact, Errors errors
//){
//    if(errors.hasErrors())return "contact";
//    contactRepository.save(contact);
//    return "redirect:/contact";
//}

    @GetMapping("/contacts")
    public Iterable<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    @GetMapping("/contact/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Contact> getContactById(@PathVariable("id") Long id){
        Optional<Contact> optContact = contactRepository.findById(id);
        return optContact.map(contact -> new ResponseEntity<>(contact, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("/contact")
    @ResponseStatus(HttpStatus.CREATED)
    public Contact postContact(@RequestBody Contact contact){
        return contactRepository.save(contact);
    }

    @PutMapping("/contact/{id}")
    public Contact putContact(@PathVariable("id") Long id,@RequestBody Contact contact){
        contact.setId(id);
        return contactRepository.save(contact);
    }

    @DeleteMapping("/contact/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable("id") Long id){
        contactRepository.deleteById(id);
    }
}
