package com.project.URL.Shortener.Services;

import com.project.URL.Shortener.DTOs.URLRequestDTO;
import org.springframework.http.ResponseEntity;

public interface ShortURLService {
    ResponseEntity<String> getShortURL(URLRequestDTO urlRequestDTO);
}
