package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.CategoryService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
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
    public DataResult<List<Category>> getAll(){
        return this.categoryService.getAll();
    }

    @GetMapping("/getByCategoryName")
    public DataResult<Category> getByCategoryName(@RequestParam String name){

        return this.categoryService.findByName(name);
    }

    @PostMapping("/add")
    public Result add(Category category){
      return   this.categoryService.add(category);
    }

    @PostMapping("/delete")
    public Result delete(Category category){
        return this.categoryService.delete(category);
    }
    @PostMapping("/update")
    public Result update(Category category){
       return this.categoryService.update(category);

    }
}
