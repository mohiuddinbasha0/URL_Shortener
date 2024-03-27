package com.project.URL.Shortener.Controllers;

import com.project.URL.Shortener.DTOs.URLRequestDTO;
import com.project.URL.Shortener.Services.ShortURLService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShortURLController {

    private ShortURLService shortURLService;

    ShortURLController(ShortURLService shortURLService) {
        this.shortURLService = shortURLService;
    }

    @PostMapping("/shortURL")
    public ResponseEntity<String> getShortURL(@RequestBody URLRequestDTO urlRequestDTO) {
        return shortURLService.getShortURL(urlRequestDTO);
    }
}
