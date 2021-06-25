package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.ProductColorService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.core.utilities.Results.SuccessDataResult;
import com.Flone.Flone.entities.concretes.ProductColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/productcolors")
public class ProductColorsController {
    private ProductColorService productColorService;

    @Autowired
    public ProductColorsController(ProductColorService productColorService){
        this.productColorService=productColorService;
    }

    @PostMapping ("/add")
    public Result add(ProductColor productColor){
        return this.productColorService.add(productColor);
    }
    @GetMapping("/getAll")
    public DataResult<List<ProductColor>> getAll(){
        return this.productColorService.getAll();
    }
    @GetMapping("/getByColorName")
    public DataResult<ProductColor> findByColorName(String name){
        return (this.productColorService.findByName(name));
    }
    @PostMapping("delete")
    public Result delete(ProductColor productColor){
        return  this.productColorService.delete(productColor);
    }
    @PostMapping("update")
    public Result update(ProductColor productColor){
        return  this.productColorService.update(productColor);
    }
}
