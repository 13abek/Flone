package com.Flone.Flone.entities.abstracts;

import com.Flone.Flone.entities.concretes.Order;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "base_customer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@MappedSuperclass
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String phone;

    @Column(name = "email")
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Column(name = "country")
    @NotNull
    @NotBlank
    private String country;

    @Column(name = "town_city")
    @NotNull
    @NotBlank
    private String townCity;

    @Column(name = "street_address")
    @NotNull
    @NotBlank
    private String streetAddress;

    @Column(name = "postcode_zip")
    @NotNull
    @NotBlank
    private String postcodeZip;


    public Customer(){

    }

    public Customer(int id, String phone, String email, String country, String townCity, String streetAddress, String postcodeZip) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.townCity = townCity;
        this.streetAddress = streetAddress;
        this.postcodeZip = postcodeZip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTownCity() {
        return townCity;
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostcodeZip() {
        return postcodeZip;
    }

    public void setPostcodeZip(String postcodeZip) {
        this.postcodeZip = postcodeZip;
    }
}
