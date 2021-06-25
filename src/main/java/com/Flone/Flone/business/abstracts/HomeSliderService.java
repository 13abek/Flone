package com.Flone.Flone.business.abstracts;

import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.HomeSlider;
import org.springframework.web.multipart.MultipartFile;

public interface HomeSliderService {
    DataResult<HomeSlider> findById(int id);
    Result add(MultipartFile file, HomeSlider homeSlider,int homeid);
    Result addDb(MultipartFile file,int homeid);
    Result delete(HomeSlider homeSlider);
    Result update(MultipartFile file,int homeSliderId,int homeId);

}
