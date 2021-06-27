package com.Flone.Flone.business.abstracts;

import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.entities.concretes.CorporateCustomer;

import java.util.List;

public interface CorporateCustomerService {
    DataResult<CorporateCustomer> findById(int id);
    DataResult<CorporateCustomer> findByEmail(String email);
    DataResult<List<CorporateCustomer>> getAll();
}
