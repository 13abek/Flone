package com.Flone.Flone.dataAccess.abstracts;

import com.Flone.Flone.entities.concretes.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerDao extends JpaRepository<CorporateCustomer,Integer> {
    CorporateCustomer findById(int id);
    CorporateCustomer findByEmail(String email);
}
