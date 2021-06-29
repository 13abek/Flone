package com.Flone.Flone.entities.concretes;

import com.Flone.Flone.entities.abstracts.Customer;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@DiscriminatorValue(value = "corporate_customers")
public class CorporateCustomer extends Customer {

    @Column(name = "company_name")
    @NotBlank
    @NotNull
    private String companyName;

    public CorporateCustomer(){

    }

    public CorporateCustomer(int id, String phone, String email, String country, String townCity, String streetAddress, String postcodeZip, String companyName) {
        super(id, phone, email, country, townCity, streetAddress, postcodeZip);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
