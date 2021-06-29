package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.ContactService;
import com.Flone.Flone.core.utilities.Results.*;
import com.Flone.Flone.entities.concretes.Contact;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerTemplateAvailabilityProvider;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.contactService.getAll());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
      return ResponseEntity.ok(this.contactService.findById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(Contact contact){
        return ResponseEntity.ok(this.contactService.add(contact));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(Contact contact){
        return ResponseEntity.ok(this.contactService.delete(contact));
    }
    @PatchMapping("/update")
    public ResponseEntity<?> update(Contact contact){
        return ResponseEntity.ok(this.contactService.update(contact));
    }


}
