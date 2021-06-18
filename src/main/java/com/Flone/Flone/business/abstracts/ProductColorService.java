package com.Flone.Flone.business.abstracts;

import com.Flone.Flone.core.utilities.Results.DataResult;
import com.Flone.Flone.core.utilities.Results.Result;
import com.Flone.Flone.entities.concretes.ProductColor;

import java.util.List;

public interface ProductColorService {
    DataResult<List<ProductColor>> getAll();
    Result add(ProductColor productColor);
    Result delete(ProductColor productColor);
    Result update(ProductColor productColor);
    DataResult<ProductColor> findByName(String name);
}
