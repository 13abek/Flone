package com.Flone.Flone.entities.concretes;

import com.Flone.Flone.entities.abstracts.BaseCustomer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int customer_id;

    @ManyToOne()
    @JoinColumn(name = "individualCustomerId")
    private IndividualCustomer individualCustomer;

    @ManyToOne()
    @JoinColumn(name = "corporateCustomerId")
    private CorporateCustomer corporateCustomer ;

    @OneToMany(mappedBy = "order")
    private List<ProductToOrder> productToOrders;
}
