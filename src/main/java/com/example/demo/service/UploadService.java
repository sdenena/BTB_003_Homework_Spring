package com.example.demo.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {
    String singleFileUpload(MultipartFile multipartFile,String folder);

    List<String> multipleFileUpload(List<MultipartFile> files,String folder);
}
