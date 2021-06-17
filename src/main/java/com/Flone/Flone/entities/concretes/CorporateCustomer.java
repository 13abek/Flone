package com.Flone.Flone.entities.concretes;

import com.Flone.Flone.entities.abstracts.BaseCustomer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "corporate_customer")
public class CorporateCustomer extends BaseCustomer {

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "corporateCustomer")
    private List<Order> orders;
}
