package com.Flone.Flone.business.abstracts;

import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.abstracts.Customer;
import com.Flone.Flone.entities.concretes.IndividualCustomer;

import java.util.List;

public interface IndividualCustomerService {
    DataResult<List<IndividualCustomer>> getAll();
    DataResult<IndividualCustomer> findById(int id);
    DataResult<IndividualCustomer> findByEmail(String email);
    Result add(IndividualCustomer customer);
    Result delete(IndividualCustomer customer);
    Result update(IndividualCustomer customer);

}
