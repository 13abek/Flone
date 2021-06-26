package com.Flone.Flone.dataAccess.abstracts;

import com.Flone.Flone.entities.concretes.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualCustomerDao extends JpaRepository<IndividualCustomer,Integer> {
    IndividualCustomer findById(int id);
    IndividualCustomer findByEmail( String email);
}
