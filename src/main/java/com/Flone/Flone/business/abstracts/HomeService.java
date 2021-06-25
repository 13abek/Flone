package com.Flone.Flone.business.abstracts;

import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.Home;

import java.util.List;

public interface HomeService {
    DataResult<List<Home>> getAll();
    Result add(Home home);
    Result delete(Home home);
    Result update(Home home);
    DataResult<Home> findById(int id);
}
