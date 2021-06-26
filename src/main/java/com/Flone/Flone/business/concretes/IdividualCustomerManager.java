package com.Flone.Flone.business.concretes;

import com.Flone.Flone.business.abstracts.IndividualCustomerService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.core.utilities.Results.SuccessDataResult;
import com.Flone.Flone.core.utilities.Results.SuccessResult;
import com.Flone.Flone.dataAccess.abstracts.IndividualCustomerDao;
import com.Flone.Flone.entities.abstracts.Customer;
import com.Flone.Flone.entities.concretes.IndividualCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdividualCustomerManager implements IndividualCustomerService {

    private IndividualCustomerDao customerDao;
    @Autowired
    public IdividualCustomerManager(IndividualCustomerDao customerDao){
        this.customerDao=customerDao;
    }

    @Override
    public DataResult<IndividualCustomer> findById(int id) {
        return new SuccessDataResult<IndividualCustomer>(this.customerDao.findById(id),"Customer found");
    }

    @Override
    public Result add(IndividualCustomer customer) {
        this.customerDao.save(customer);
        return new SuccessResult("Customer add");
    }
}
