package com.Flone.Flone.business.concretes;

import com.Flone.Flone.business.abstracts.CorporateCustomerService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.SuccessDataResult;
import com.Flone.Flone.dataAccess.abstracts.CorporateCustomerDao;
import com.Flone.Flone.entities.concretes.CorporateCustomer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporateCustomerManager implements CorporateCustomerService {
    private CorporateCustomerDao customerDao;
    public CorporateCustomerManager(CorporateCustomerDao customerDao){
        this.customerDao=customerDao;
    }
    @Override
    public DataResult<CorporateCustomer> findById(int id) {
        return new SuccessDataResult<CorporateCustomer>(this.customerDao.findById(id),"found");
    }

    @Override
    public DataResult<CorporateCustomer> findByEmail (String email) {
        return new SuccessDataResult<CorporateCustomer>(this.customerDao.findByEmail(email));
    }

    @Override
    public DataResult<List<CorporateCustomer>> getAll() {
        return new SuccessDataResult<List<CorporateCustomer>>(this.customerDao.findAll());
    }
}
