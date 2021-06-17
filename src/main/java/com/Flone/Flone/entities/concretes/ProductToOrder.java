package com.Flone.Flone.entities.concretes;

import javax.persistence.*;

@Entity
@Table(name = "product_orders")
public class ProductToOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "orderId")
    private Order order;
}
