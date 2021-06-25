package com.Flone.Flone.business.abstracts;

import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.Contact;

public interface ContactService {
    DataResult<Contact> findById(int id);
    Result add(Contact contact);
    Result delete(Contact contact);
}
