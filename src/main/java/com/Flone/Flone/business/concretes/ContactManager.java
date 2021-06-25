package com.Flone.Flone.business.concretes;

import com.Flone.Flone.business.abstracts.ContactService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.SuccessDataResult;
import com.Flone.Flone.dataAccess.abstracts.ContactDao;
import com.Flone.Flone.entities.concretes.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactManager implements ContactService {
    private ContactDao contactDao;
    public ContactManager(ContactDao contactDao){
        this.contactDao=contactDao;
    }

    @Override
    public DataResult<Contact> findById(int id) {
        return new SuccessDataResult<Contact>(this.contactDao.findById(id),"Contact found");

    }
}
