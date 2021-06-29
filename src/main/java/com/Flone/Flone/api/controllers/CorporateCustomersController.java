package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.CorporateCustomerService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.CorporateCustomer;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> findById(@PathVariable int id){
        return ResponseEntity.ok(this.customerService.findById(id));
    }
    @GetMapping("/getbyemail/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(this.customerService.findByEmail(email));
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.customerService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(CorporateCustomer customer){
        return ResponseEntity.ok(this.customerService.add(customer));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(CorporateCustomer customer){
        return ResponseEntity.ok(this.customerService.delete(customer));
    }
    @PatchMapping("/update")
    public ResponseEntity<?> update(CorporateCustomer customer){
        return ResponseEntity.ok(this.customerService.update(customer));
    }
}
