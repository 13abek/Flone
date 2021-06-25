package com.Flone.Flone.business.concretes;

import com.Flone.Flone.business.abstracts.ContactService;
import com.Flone.Flone.core.utilities.Results.*;
import com.Flone.Flone.dataAccess.abstracts.ContactDao;
import com.Flone.Flone.entities.concretes.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactManager implements ContactService {
    private ContactDao contactDao;
    public ContactManager(ContactDao contactDao){
        this.contactDao=contactDao;
    }

    @Override
    public DataResult<List<Contact>> getAll() {
        return new SuccessDataResult<List<Contact>>(this.contactDao.findAll(),"Contact Lists!");
    }

    @Override
    public DataResult<Contact> findById(int id) {
        return new SuccessDataResult<Contact>(this.contactDao.findById(id),"Contact found");

    }

    @Override
    public Result add(Contact contact) {
        this.contactDao.save(contact);
        return new SuccessResult("Contact Added !");
    }

    @Override
    public Result delete(Contact contact) {
        this.contactDao.delete(contact);
        return new SuccessResult("Contact deleted!");
    }

    @Override
    public Result update(Contact contact) {
       Contact updateToContact= this.contactDao.findById(contact.getId());
       updateToContact.setAddress(contact.getAddress());
       updateToContact.setEmail(contact.getEmail());
       updateToContact.setPhone(contact.getPhone());
       this.contactDao.save(updateToContact);
        return new SuccessResult("Contact has been updated!");
    }

}
