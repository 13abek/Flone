package com.Flone.Flone.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @NotEmpty
    private String name;

    @Email
    @NotBlank
    @NotEmpty
    private String email;

    @NotNull
    @NotBlank
    private double star;

    @Email
    @NotBlank
    @NotEmpty
    private String content;

    @ManyToOne()
    @JoinColumn(name = "productId")
    private Product product;

    public Review(){

    }

    public Review(int id, String name, String email, double star, String content) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.star = star;
        this.content = content;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
