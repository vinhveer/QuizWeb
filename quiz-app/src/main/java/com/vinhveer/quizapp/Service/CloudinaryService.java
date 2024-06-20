package com.vinhveer.quizapp.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface CloudinaryService {
    public String uploadFile(MultipartFile file);
}
