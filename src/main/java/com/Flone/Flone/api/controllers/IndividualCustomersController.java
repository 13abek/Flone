package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.IndividualCustomerService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.IndividualCustomer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/individualcustomer/")
public class IndividualCustomersController {
    private IndividualCustomerService customerService;
    public IndividualCustomersController (IndividualCustomerService customerService){
        this.customerService=customerService;
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.customerService.getAll());
    }
    @GetMapping("/getbyid")
    public ResponseEntity<?>  findbyid(int id){
        return ResponseEntity.ok(this.customerService.getAll());
    }
    @GetMapping("/getbyemail")
    public ResponseEntity<?>  findByEmail(String email){
        return ResponseEntity.ok(this.customerService.findByEmail(email));
    }
    @PostMapping("/add")
    public ResponseEntity<?>  add(IndividualCustomer customer){
        return ResponseEntity.ok(this.customerService.add(customer));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?>  delete(IndividualCustomer customer){
      return ResponseEntity.ok(this.customerService.delete(customer));
    }
    @PatchMapping("/update")
    public ResponseEntity<?>  update(IndividualCustomer customer){
        return ResponseEntity.ok(this.customerService.update(customer));
    }
}
