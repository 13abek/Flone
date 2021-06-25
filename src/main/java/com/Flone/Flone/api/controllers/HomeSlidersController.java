package com.Flone.Flone.api.controllers;


import com.Flone.Flone.business.abstracts.HomeSliderService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.Home;
import com.Flone.Flone.entities.concretes.HomeSlider;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/homeSliders")
public class HomeSlidersController {
    private HomeSliderService homeSliderService;
    public HomeSlidersController(HomeSliderService homeSliderService){
        this.homeSliderService=homeSliderService;
    }

    @PostMapping("/home/{id}/add")
    public Result add(@RequestParam("file") MultipartFile file, HomeSlider homeSlider, @PathVariable int id){
      return  this.homeSliderService.add(file,homeSlider,id);
    }
    @PostMapping("/home/{id}/addDb")
    public Result addDb(@RequestParam("file") MultipartFile file,@PathVariable int id){
        return this.homeSliderService.addDb(file,id);
    }
    @PostMapping("/delete")
    public Result delete(HomeSlider homeSlider){
        return this.homeSliderService.delete(homeSlider);
    }

    @GetMapping("/findById/{id}")
    public DataResult<HomeSlider> findById(@PathVariable int id){
      return   this.homeSliderService.findById(id);
    }
}
