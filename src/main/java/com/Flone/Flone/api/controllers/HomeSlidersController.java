package com.Flone.Flone.api.controllers;


import com.Flone.Flone.business.abstracts.HomeSliderService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.Home;
import com.Flone.Flone.entities.concretes.HomeSlider;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> add(@RequestParam("file") MultipartFile file, HomeSlider homeSlider, @PathVariable int id){
      return ResponseEntity.ok(this.homeSliderService.add(file,homeSlider,id));
    }
    @PostMapping("/home/{id}/addDb")
    public ResponseEntity<?> addDb(@RequestParam("file") MultipartFile file,@PathVariable int id){
        return ResponseEntity.ok(this.homeSliderService.addDb(file,id));
    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(HomeSlider homeSlider){
        return ResponseEntity.ok(this.homeSliderService.delete(homeSlider));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
      return ResponseEntity.ok(this.homeSliderService.findById(id));
    }
}
