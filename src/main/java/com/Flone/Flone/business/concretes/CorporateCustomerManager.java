package com.Flone.Flone.business.concretes;

import com.Flone.Flone.business.abstracts.CorporateCustomerService;
import com.Flone.Flone.core.utilities.Results.*;
import com.Flone.Flone.core.utilities.emailValidation.EmailValidationService;
import com.Flone.Flone.dataAccess.abstracts.CorporateCustomerDao;
import com.Flone.Flone.entities.concretes.CorporateCustomer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporateCustomerManager implements CorporateCustomerService {
    private CorporateCustomerDao customerDao;
    private EmailValidationService emailValidationService;
    public CorporateCustomerManager(CorporateCustomerDao customerDao,EmailValidationService emailValidationService){
        this.customerDao=customerDao;
        this.emailValidationService=emailValidationService;
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

    @Override
    public Result add(CorporateCustomer customer) {
        if (!this.emailValidationService.validate(customer.getEmail())){
            return new ErrorResult("Invalid email,please try again !");
        }
        this.customerDao.save(customer);
        return new SuccessResult("Corporate Customer added");
    }

    @Override
    public Result delete(CorporateCustomer customer) {
        this.customerDao.delete(customer);
        return new SuccessResult("Corporate Customer Deleted");

    }

    @Override
    public Result update(CorporateCustomer customer) {
       CorporateCustomer updateToCustomer= this.customerDao.findById(customer.getId());
       updateToCustomer.setCompanyName(customer.getCompanyName());
       updateToCustomer.setEmail(customer.getEmail());
       updateToCustomer.setPhone(customer.getPhone());
       updateToCustomer.setCountry(customer.getCountry());
       updateToCustomer.setPostcodeZip(customer.getPostcodeZip());
       updateToCustomer.setStreetAddress(customer.getStreetAddress());
       updateToCustomer.setTownCity(customer.getTownCity());

       this.customerDao.save(updateToCustomer);

        return new SuccessResult("Corporate Customer update successfuly");
    }
}
