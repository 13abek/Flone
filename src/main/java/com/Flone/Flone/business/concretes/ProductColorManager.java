package com.Flone.Flone.business.concretes;

import com.Flone.Flone.business.abstracts.ProductColorService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.core.utilities.Results.SuccessDataResult;
import com.Flone.Flone.core.utilities.Results.SuccessResult;
import com.Flone.Flone.dataAccess.abstracts.ProductColorDao;
import com.Flone.Flone.entities.concretes.ProductColor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductColorManager implements ProductColorService{

    private ProductColorDao productColorDao;

    public ProductColorManager(ProductColorDao productColorDao){
        this.productColorDao=productColorDao;
    }
    @Override
    public DataResult<List<ProductColor>> getAll() {
        return  new SuccessDataResult<List<ProductColor>>(this.productColorDao.findAll(),"All colors list!");
    }

    @Override
    public Result add(ProductColor productColor) {
        this.productColorDao.save(productColor);
        return new SuccessResult("Color added!");
    }

    @Override
    public Result delete(ProductColor productColor) {
        this.productColorDao.delete(productColor);
        return new SuccessResult("Color has been deleted!");
    }

    @Override
    public Result update(ProductColor productColor) {
        ProductColor colorTOUpdated=this.productColorDao.findById(productColor.getId()).get();
        colorTOUpdated.setName(productColor.getName());
        this.productColorDao.save(colorTOUpdated);
        return new SuccessResult("color has been updated!");
    }

    @Override
    public DataResult<ProductColor> findByName(String name) {
        return new SuccessDataResult<ProductColor>(this.productColorDao.findByName(name),"color Found!");
    }
}
