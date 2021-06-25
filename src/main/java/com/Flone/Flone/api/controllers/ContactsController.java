package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.ContactService;
import com.Flone.Flone.core.utilities.Results.*;
import com.Flone.Flone.entities.concretes.Contact;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerTemplateAvailabilityProvider;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactsController {
    private ContactService contactService;
    public ContactsController(ContactService contactService){
        this.contactService=contactService;
    }

    @GetMapping("/getall")
    public DataResult<List<Contact>> getAll(){
        return this.contactService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public DataResult<Contact> getById(@PathVariable int id){
      return   this.contactService.findById(id);
    }
    @PostMapping("/add")
    public Result add(Contact contact){
        return this.contactService.add(contact);
    }
    @DeleteMapping("/delete")
    public Result delete(Contact contact){
        return this.contactService.delete(contact);
    }
    @PatchMapping("/update")
    public Result update(Contact contact){
        return  this.contactService.update(contact);
    }


}
