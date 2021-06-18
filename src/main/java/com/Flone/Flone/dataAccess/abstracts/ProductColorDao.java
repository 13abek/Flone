package com.Flone.Flone.dataAccess.abstracts;

import com.Flone.Flone.entities.concretes.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductColorDao extends JpaRepository<ProductColor,Integer> {
    ProductColor findByName (String name);
}
