package com.project.URL.Shortener.Services;

import org.springframework.http.ResponseEntity;

public interface LongURLService {
    ResponseEntity<Object> getLongURL(String shortURI);
}
