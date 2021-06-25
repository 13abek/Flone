package com.Flone.Flone.core.utilities.fileManager.exception;

public class FileStorageException extends RuntimeException{
    public FileStorageException(String message){
        super(message);
    }
    public FileStorageException(String message,Throwable cause){
        super(message,cause);
    }
}
