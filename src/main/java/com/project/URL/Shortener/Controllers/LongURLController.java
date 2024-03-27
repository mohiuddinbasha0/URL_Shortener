package com.project.URL.Shortener.Controllers;

import com.project.URL.Shortener.Services.LongURLService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LongURLController {

    private LongURLService longURLService;

    LongURLController(LongURLService longURLService) {
        this.longURLService = longURLService;
    }

    @GetMapping("/")
    public String base() {
        return "URL Shortener";
    }

    @GetMapping("/{shortURI}")
    public ResponseEntity<Object> getLongURL(@PathVariable("shortURI") String shortURI) {
        return longURLService.getLongURL(shortURI);
    }
}
