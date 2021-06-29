package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.CategoryService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.categoryService.getAll());
    }

    @GetMapping("/getByCategoryName")
    public ResponseEntity<?> getByCategoryName(@RequestParam String name){

        return  ResponseEntity.ok(this.categoryService.findByName(name));

    }

    @PostMapping("/add")
    public ResponseEntity<?> add(Category category){
      return  ResponseEntity.ok(this.categoryService.add(category));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(Category category){
        return ResponseEntity.ok(this.categoryService.delete(category));
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(Category category){
       return ResponseEntity.ok(this.categoryService.update(category));

    }
}
