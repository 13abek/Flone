package com.Flone.Flone.business.concretes;

import com.Flone.Flone.business.abstracts.CategoryService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.core.utilities.Results.SuccessDataResult;
import com.Flone.Flone.core.utilities.Results.SuccessResult;
import com.Flone.Flone.dataAccess.abstracts.CategoryDao;
import com.Flone.Flone.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao){
        this.categoryDao=categoryDao;
    }
    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccessDataResult<List<Category>>(this.categoryDao.findAll(),"category lists!");
    }

    @Override
    public Result add(Category category) {
        this.categoryDao.save(category);
        return new SuccessResult("Category added!");
    }

    @Override
    public Result delete(Category category) {
        this.categoryDao.delete(category);
        return new SuccessResult("Category Deleted Successfuly!");
    }

    @Override
    public Result update(Category category) {
        Category categoryToUpdate=this.categoryDao.findById(category.getId()).get();
        categoryToUpdate.setName(category.getName());
        this.categoryDao.save(categoryToUpdate);

        return new SuccessResult("Category has been updated!");
    }

    @Override
    public DataResult<Category> findByName(String name) {
        return  new SuccessDataResult<Category>(this.categoryDao.findByName(name),"category found");
    }


}
