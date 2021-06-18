package com.Flone.Flone.dataAccess.abstracts;

import com.Flone.Flone.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    Category findByName(String name);
}
