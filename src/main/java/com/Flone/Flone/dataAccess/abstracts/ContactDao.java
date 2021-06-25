package com.Flone.Flone.dataAccess.abstracts;

import com.Flone.Flone.entities.concretes.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact,Integer> {
    Contact findById(int id);
}
