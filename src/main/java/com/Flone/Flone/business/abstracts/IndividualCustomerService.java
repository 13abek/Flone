package com.Flone.Flone.business.abstracts;

import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.abstracts.Customer;
import com.Flone.Flone.entities.concretes.IndividualCustomer;

public interface IndividualCustomerService {
    DataResult<IndividualCustomer> findById(int id);
    Result add(IndividualCustomer customer);

}
