package com.example.imageserviceapi.service;

import com.example.imageserviceapi.model.Image;

public interface ImageDownloadService {
    Image download(String name);
}
