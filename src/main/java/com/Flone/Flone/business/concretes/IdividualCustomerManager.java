package com.Flone.Flone.business.concretes;

import com.Flone.Flone.business.abstracts.IndividualCustomerService;
import com.Flone.Flone.core.utilities.Results.*;
import com.Flone.Flone.core.utilities.emailValidation.EmailValidationService;
import com.Flone.Flone.dataAccess.abstracts.IndividualCustomerDao;
import com.Flone.Flone.entities.abstracts.Customer;
import com.Flone.Flone.entities.concretes.IndividualCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdividualCustomerManager implements IndividualCustomerService {

    private IndividualCustomerDao customerDao;
    private EmailValidationService emailValidationService;
    @Autowired
    public IdividualCustomerManager(IndividualCustomerDao customerDao,EmailValidationService emailValidationService){
        this.customerDao=customerDao;
        this.emailValidationService=emailValidationService;
    }

    @Override
    public DataResult<List<IndividualCustomer>> getAll() {
        return new SuccessDataResult<List<IndividualCustomer>>(this.customerDao.findAll(),"Individual Customer Lists");
    }

    @Override
    public DataResult<IndividualCustomer> findById(int id) {
        return new SuccessDataResult<IndividualCustomer>(this.customerDao.findById(id),"Customer found");
    }

    @Override
    public DataResult<IndividualCustomer> findByEmail(String email) {
        return new SuccessDataResult<IndividualCustomer>(this.customerDao.findByEmail(email),"Customer found!");
    }

    @Override
    public Result add(IndividualCustomer customer) {
        if (!this.emailValidationService.validate(customer.getEmail())){
            return new ErrorResult("Invalid email,Please try again !");
        }
        this.customerDao.save(customer);
        return new SuccessResult("Customer add");
    }

    @Override
    public Result delete(IndividualCustomer customer) {
        this.customerDao.delete(customer);
        return new SuccessResult("individualCustomer deleted");
    }

    @Override
    public Result update(IndividualCustomer customer) {
      IndividualCustomer  updateToCustomer=this.customerDao.findById(customer.getId());
      System.out.println(updateToCustomer.getFirstName() + updateToCustomer.getCountry());
      updateToCustomer.setCountry(customer.getCountry());
      updateToCustomer.setEmail(customer.getEmail());
      updateToCustomer.setPhone(customer.getPhone());
      updateToCustomer.setStreetAddress(customer.getStreetAddress());
      updateToCustomer.setTownCity(customer.getTownCity());
      updateToCustomer.setPostcodeZip(customer.getPostcodeZip());
      updateToCustomer.setFirstName(customer.getFirstName());
      updateToCustomer.setLastName(customer.getLastName());
      this.customerDao.save(updateToCustomer);
        return new SuccessResult("IndividualCustomer updated");
    }
}
