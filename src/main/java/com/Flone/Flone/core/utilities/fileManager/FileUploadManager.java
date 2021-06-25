package com.Flone.Flone.core.utilities.fileManager;


import com.Flone.Flone.core.utilities.fileManager.exception.FileStorageException;
import com.Flone.Flone.core.utilities.fileManager.fileProperty.FileStorageProperties;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadManager implements FileUploadService{
    private final Path fileStorageLocation;

    public FileUploadManager(FileStorageProperties fileStorageProperties){
        this.fileStorageLocation=Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

        try{
            Files.createDirectories(this.fileStorageLocation);
        }catch (Exception exception){
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",exception);
        }

    }

    @Override
    public String uploadFile(@NotNull MultipartFile file,int homeSliderId) {
            String originalFileName= StringUtils.cleanPath(file.getOriginalFilename());
            String fileName="";

            try {
                //Check if the file's name contains invalid characters
                if (originalFileName.contains("..")){
                    throw new FileStorageException("Sorry! FileName contains invalid path sequance" + originalFileName);
                }
                String fileExstention="";
                try {
                    fileExstention=originalFileName.substring(originalFileName.lastIndexOf("."));
                }catch (Exception ex){
                    fileExstention="";
                }
                fileName=homeSliderId + "_"+fileExstention;
               // Copy file to the target location (Replacing existing file with the same name)
                Path targetLocaton=this.fileStorageLocation.resolve(fileName);
                Files.copy(file.getInputStream(),targetLocaton, StandardCopyOption.REPLACE_EXISTING);

               return fileName;
           }catch (IOException exception){
                throw new FileStorageException("Could not store file" + fileName + ".Please try again" ,exception);
            }

    }

    @Override
    public String deleteFile(@NotNull MultipartFile file) {
        
        return null;
    }


}
