package com.Flone.Flone.entities.concretes;

import com.Flone.Flone.entities.abstracts.Customer;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(name = "date")
    private Date date;
    @NotNull
    @NotEmpty
    @Column(name = "amount")
    private int amount;
    @NotNull
    @NotEmpty
    @NotBlank
    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order(){

    }

    public Order(int id, Date date, int amount, double price,Customer customer) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.price = price;
        this.product = product;
        this.customer=customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void addCustomer(Customer customer){
        this.customer=customer;
    }
}
