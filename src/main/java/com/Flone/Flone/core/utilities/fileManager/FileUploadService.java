package com.Flone.Flone.core.utilities.fileManager;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public interface FileUploadService {
    public String uploadFile(MultipartFile file,int homeSliderid);
    public String deleteFile(MultipartFile file);
}
