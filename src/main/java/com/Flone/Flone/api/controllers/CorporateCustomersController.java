package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.CorporateCustomerService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.CorporateCustomer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corporatecustomer")
public class CorporateCustomersController {
    private CorporateCustomerService customerService;
    public CorporateCustomersController(CorporateCustomerService customerService){
        this.customerService=customerService;
    }
    @GetMapping("/getbyid/{id}")
    public DataResult<CorporateCustomer> findById(@PathVariable int id){
        return this.customerService.findById(id);
    }
    @GetMapping("/getbyemail/{email}")
    public DataResult<CorporateCustomer> findByEmail(@PathVariable String email){
        return this.customerService.findByEmail(email);
    }
    @GetMapping("/getall")
    public DataResult<List<CorporateCustomer>> getAll(){
        return this.customerService.getAll();
    }
    @PostMapping("/add")
    public Result add(CorporateCustomer customer){
        return this.customerService.add(customer);
    }
    @DeleteMapping("/delete")
    public Result delete(CorporateCustomer customer){
        return this.customerService.delete(customer);
    }
    @PatchMapping("/update")
    public Result update(CorporateCustomer customer){
        return this.customerService.update(customer);
    }
}
