package com.example.contact.data;

import com.example.contact.contact.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,String> {
}
