package com.Flone.Flone.business.concretes;

import com.Flone.Flone.business.abstracts.HomeService;
import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.core.utilities.Results.SuccessDataResult;
import com.Flone.Flone.core.utilities.Results.SuccessResult;
import com.Flone.Flone.dataAccess.abstracts.HomeDao;
import com.Flone.Flone.entities.concretes.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeManager implements HomeService {

    private HomeDao homeDao;
    @Autowired
    public HomeManager(HomeDao homeDao){
        this.homeDao=homeDao;
    }
    @Override
    public DataResult<List<Home>> getAll() {
        return new SuccessDataResult<List<Home>>(this.homeDao.findAll(),"Home pages Lists!");
    }

    @Override
    public Result add(Home home) {

        this.homeDao.save(home);

        return new SuccessResult("Home page updated!");
    }

    @Override
    public Result delete(Home home) {
        this.homeDao.delete(home);
        return new SuccessResult("Home page Has been deleted!");
    }

    @Override
    public Result update(Home home) {
      Home updateToHome=this.homeDao.findById(home.getId());
      updateToHome.setTitle(home.getTitle());
      updateToHome.setUpperTitle(home.getUpperTitle());
      this.homeDao.save(updateToHome);
        return new SuccessResult("home page updated");
    }

    @Override
    public DataResult<Home> findById(int id) {
        return new SuccessDataResult<Home>(this.homeDao.findById(id),"find!");
    }
}
