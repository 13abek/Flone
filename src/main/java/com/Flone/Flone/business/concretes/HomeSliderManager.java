package com.Flone.Flone.business.concretes;

import com.Flone.Flone.business.abstracts.HomeService;
import com.Flone.Flone.business.abstracts.HomeSliderService;
import com.Flone.Flone.core.utilities.Results.*;
import com.Flone.Flone.core.utilities.fileManager.FileUploadService;
import com.Flone.Flone.dataAccess.abstracts.HomeSliderDao;
import com.Flone.Flone.entities.concretes.Home;
import com.Flone.Flone.entities.concretes.HomeSlider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class HomeSliderManager implements HomeSliderService {
        private FileUploadService fileUploadService;
        private HomeSliderDao homeSliderDao;
        private HomeService homeService;
        @Autowired
        public HomeSliderManager(HomeSliderDao homeSliderDao, FileUploadService fileUploadService,HomeService homeService){
            this.homeSliderDao=homeSliderDao;
            this.fileUploadService=fileUploadService;
            this.homeService=homeService;
        }

    @Override
    public Result add(MultipartFile file, HomeSlider homeSlider,int homeId) {
           DataResult<Home> home1= this.homeService.findById(homeId);
            if (!home1.isSuccess()){
                return new ErrorResult("this Home page not founded!");
            }
            this.fileUploadService.uploadFile(file,homeSlider.getId());
            HomeSlider addedToHomeSlider=new HomeSlider();
            addedToHomeSlider.setName(file.getOriginalFilename());
            addedToHomeSlider.setType(file.getContentType());
            addedToHomeSlider.addHome(home1.getData());

            this.homeSliderDao.save(addedToHomeSlider);
        return new SuccessResult("HomeSliders added!");
    }

    @Override
    public Result addDb(MultipartFile file, int homeid) {

        HomeSlider homeSlider=new HomeSlider();
        DataResult<Home> home1= this.homeService.findById(homeid);
        if (!home1.isSuccess()){
            return new ErrorResult("this Home page not founded!");
        }
        try {
                homeSlider.setData(file.getBytes());
                homeSlider.setType(file.getContentType());
                homeSlider.setName(file.getOriginalFilename());
                homeSlider.addHome(home1.getData());
                this.homeSliderDao.save(homeSlider);

            }catch (IOException exception){
                exception.printStackTrace();
            }
        return new SuccessResult("home Slider added Succesfuly!");
    }
    @Override
    public Result delete(HomeSlider homeSlider) {
        this.homeSliderDao.delete(homeSlider);
        return new SuccessResult("home slider deleted");
    }

    @Override
    public Result update(MultipartFile file,int homeSliderId,int homeId) {
          HomeSlider deleteToHomeSlider= this.homeSliderDao.getById(homeSliderId);
          DataResult<Home> deletedSlidersHomePage=this.homeService.findById(homeId);
            this.homeSliderDao.delete(deleteToHomeSlider);
            HomeSlider updateToHomeSlider=new HomeSlider();
            try {
                updateToHomeSlider.setData(file.getBytes());
                updateToHomeSlider.setType(file.getContentType());
                updateToHomeSlider.setName(file.getOriginalFilename());
                updateToHomeSlider.addHome(deletedSlidersHomePage.getData());

            }catch (IOException exception){
                exception.printStackTrace();
            }
        return new SuccessResult("Home slider updated !");
    }

    @Override
    public DataResult<HomeSlider> findById(int id) {
        HomeSlider findHomeSlider=this.homeSliderDao.findById(id);
        return new DataResult<HomeSlider>(findHomeSlider,true,"HomeSlider found");
    }
}
