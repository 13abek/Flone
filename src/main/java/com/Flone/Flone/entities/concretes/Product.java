package com.Flone.Flone.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "name")
    @NotBlank
    @NotNull
    private String name;

    @Column(name = "price")
    @NotBlank
    @NotNull
    private double price;

    @Column(name = "units_in_stock")
    @NotBlank
    @NotNull
    private int unitsInStock;

    @Column(name = "star_count")
    private int starCount;

    @Column(name = "discount")
    @NotBlank
    @NotNull
    private double discount;

    @Column(name = "text")
    @NotBlank
    @NotNull
    private String text;

    @Column(name = "is_best_sellers")
    @NotBlank
    @NotNull
    private  boolean isBestSellers;

    @Column(name = "is_new")
    @NotBlank
    @NotNull
    private boolean isNew;

    @ManyToOne()
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "productColorId")
    private ProductColor productColor;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToMany(mappedBy = "product")
    private List<Order> orders; //Deqiqdeyil>?????


    public Product(){

    }
    public Product(int id, String name, double price, int unitsInStock, int starCount, double discount, String text, boolean isBestSellers, boolean isNew,ProductColor productColor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unitsInStock = unitsInStock;
        this.starCount = starCount;
        this.discount = discount;
        this.text = text;
        this.isBestSellers = isBestSellers;
        this.isNew = isNew;
        //
        this.productColor=productColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isBestSellers() {
        return isBestSellers;
    }

    public void setBestSellers(boolean bestSellers) {
        isBestSellers = bestSellers;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
    /////
    ///


    public void addProductColor(ProductColor productColor) {
        this.productColor = productColor;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
