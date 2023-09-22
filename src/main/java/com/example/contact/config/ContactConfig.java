package com.example.contact.config;

import com.example.contact.contact.ContactRepository;
import com.example.contact.contact.ContactRepositoryImpl;
import com.example.contact.contact.ContactService;
import com.example.contact.contact.ContactServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactConfig {
    @Bean
    ContactService contactService(ContactRepository contactRepository){
        return new ContactServiceImpl(contactRepository);
    }

    @Bean
    ContactRepository contactRepository(){
        return new ContactRepositoryImpl();
    }
}
