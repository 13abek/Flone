package com.Flone.Flone.entities.concretes;

import com.Flone.Flone.entities.abstracts.Customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "individual_customers")
public class IndividualCustomer extends Customer {
    @Column(name = "first_name")
    @NotNull
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @NotBlank
    private String lastName;

    @OneToMany(mappedBy = "individualCustomer")
    private List<Order>orders;
    public IndividualCustomer(){

    }

    public IndividualCustomer(int id, String phone, String email, String country, String townCity, String streetAddress, String postcodeZip, String firstName, String lastName) {
        super(id, phone, email, country, townCity, streetAddress, postcodeZip);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
