package com.Flone.Flone.api.controllers;

import com.Flone.Flone.business.abstracts.HomeService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.Home;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/homes")
public class HomesController {
    private HomeService homeService;
    public HomesController(HomeService homeService){
        this.homeService=homeService;
    }
    @PostMapping("/add")
    public Result add(Home home){
        return this.homeService.add(home);
    }

    @GetMapping("/getAll")
    public DataResult<List<Home>> getAll(){
     return    this.homeService.getAll();
    }
}
