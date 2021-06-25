package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.ContactService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.entities.concretes.Contact;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactsController {
    private ContactService contactService;
    public ContactsController(ContactService contactService){
        this.contactService=contactService;
    }

    @GetMapping("/getbyid/{id}")
    public DataResult<Contact> getById(int id){
      return   this.contactService.findById(id);
    }
}
