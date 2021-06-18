package com.Flone.Flone.core.utilities.Results;

import com.Flone.Flone.core.utilities.Results.DataResult;

public class ErrorDataResult<T> extends DataResult<T> {
    public ErrorDataResult(T data,String message){
        super(data,false,message);
    }
    public ErrorDataResult(T data){
        super(data,false);
    }
    public ErrorDataResult(String message){
        super(null,false,message);
    }
    public ErrorDataResult(){
        super(null,false);
    }
}
