package com.example.imageserviceapi.service.impl;

import java.util.Locale;
import java.util.Random;
import com.example.imageserviceapi.model.Image;
import com.example.imageserviceapi.service.ImageDownloadService;
import org.springframework.stereotype.Service;

@Service
public class ImageDownloadServiceImpl implements ImageDownloadService {
    public static final String PRIMARY_LINK = "https://user-api/images/";

    @Override
    public Image download(String name) {
        Image image = new Image();
        Image.ImageType imageType = generateImageType();
        image.setLink(linkGenerator(name, imageType));
        image.setSize(new Random().nextInt(5000));
        image.setName(name);
        image.setImageType(imageType);
        return image;
    }

    private String linkGenerator(String name, Image.ImageType imageType) {
        return PRIMARY_LINK
                + name
                + "."
                + imageType.toString().toLowerCase(Locale.ROOT);
    }

    private Image.ImageType generateImageType() {
        return Image.ImageType.values()[new Random().nextInt(Image.ImageType.values().length)];
    }
}
