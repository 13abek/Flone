package com.Flone.Flone.entities.concretes;

import com.Flone.Flone.entities.abstracts.BaseCustomer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "individual_customers")
public class IndividualCustomer extends BaseCustomer {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "individualCustomer")
    private List<Order>orders;
}
