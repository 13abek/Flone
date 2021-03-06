package com.Flone.Flone.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product_images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "type")
    @NotNull
    @NotBlank
    private String type;
    @NotNull
    @NotBlank
    @Lob
    private byte[] data;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductImage(){

    }

    public ProductImage(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    public void addProduct(@NotNull Product product){
        this.product=product;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
