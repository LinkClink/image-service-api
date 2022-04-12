package com.example.imageserviceapi.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.example.imageserviceapi.model.Account;
import com.example.imageserviceapi.model.Image;
import com.example.imageserviceapi.model.Tag;
import com.example.imageserviceapi.service.AccountService;
import com.example.imageserviceapi.service.ImageDownloadService;
import com.example.imageserviceapi.service.ImageService;
import com.example.imageserviceapi.service.TagService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;
    private final TagService tagService;
    private final AccountService accountService;
    private final ImageDownloadService imageDownloadService;

    public ImageController(ImageService imageService,
                           TagService tagService, AccountService accountService,
                           ImageDownloadService imageDownloadService) {
        this.imageService = imageService;
        this.tagService = tagService;
        this.accountService = accountService;
        this.imageDownloadService = imageDownloadService;
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody Image image,
                         Authentication authentication) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        Optional<Account> account = accountService.getByEmail(details.getUsername());
        Optional<Image> imageById = imageService.getById(id);
        if (imageById.get().getAccount().getEmail().equals(account.get().getEmail())) {
            image.setId(id);
            imageService.save(image);
            return "Success update image: " + image;
        }
        return "Account can`t access to this image";
    }

    @PostMapping("/save/{imageName}")
    public Image save(@PathVariable String imageName, Authentication authentication) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        Optional<Account> account = accountService.getByEmail(details.getUsername());
        Image image = imageDownloadService.download(imageName);
        image.setAccount(account.get());
        return imageService.save(image);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Authentication authentication) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        Optional<Account> account = accountService.getByEmail(details.getUsername());
        Optional<Image> image = imageService.getById(id);
        if (image.isEmpty()) {
            return "Image not found " + id;
        }
        if (image.get().getAccount().getEmail().equals(account.get().getEmail())) {
            imageService.delete(image.get());
            return "Success delete image: " + image.get();
        }
        return "User can`t have permissions to delete this image: " + id;
    }

    @GetMapping("/tag/{tagName}")
    public List<Image> findByTag(@PathVariable String tagName) {
        Optional<Tag> tag = tagService.findByName(tagName);
        Set<Tag> tags = new HashSet<>();
        tags.add(tag.get());
        return imageService.findByTags(tags);
    }
}
