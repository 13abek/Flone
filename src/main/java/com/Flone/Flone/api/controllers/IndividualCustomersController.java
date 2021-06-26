package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.IndividualCustomerService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.IndividualCustomer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/individualcustomer/")
public class IndividualCustomersController {
    private IndividualCustomerService customerService;
    public IndividualCustomersController (IndividualCustomerService customerService){
        this.customerService=customerService;
    }
    @GetMapping("/getbyid")
    public DataResult<IndividualCustomer> findbyid(int id){
        return this.customerService.findById(id);
    }
    @PostMapping("/add")
    public Result add(IndividualCustomer customer){
        return this.customerService.add(customer);
    }
    @DeleteMapping("/delete")
    public Result delete(IndividualCustomer customer){
      return this.customerService.delete(customer);
    }
}