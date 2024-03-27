package com.project.URL.Shortener.Services;

import com.project.URL.Shortener.DTOs.URLRequestDTO;
import com.project.URL.Shortener.Models.LongURL;
import com.project.URL.Shortener.Models.ShortURL;
import com.project.URL.Shortener.Repositories.ShortURLRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Base64;

@Service
public class ShortURLServiceImpl implements ShortURLService{

    private ShortURLRepository shortURLRepository;

    ShortURLServiceImpl(ShortURLRepository shortURLRepository) {
        this.shortURLRepository = shortURLRepository;
    }

    @Override
    public ResponseEntity<String> getShortURL(URLRequestDTO urlRequestDTO) {

        try {

            UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});

            if(!urlValidator.isValid(urlRequestDTO.getUrl())) {
                return new ResponseEntity<>("Bad URL", HttpStatus.BAD_REQUEST);
            }

            ShortURL shorturl = new ShortURL();

            LongURL longURL = new LongURL();
            longURL.setUrl(urlRequestDTO.getUrl());
            longURL.setShortURL(shorturl);

            shorturl.setLongURL(longURL);

            shorturl = shortURLRepository.save(shorturl);

            URI uri = URI.create(shorturl.getProtocol()+"://"+shorturl.getDomain()+"/"+getShortnedPath(shorturl.getLongURL().getId()));

            return new ResponseEntity<>(uri.toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String getShortnedPath(Long id) {
        return Base64.getEncoder().encodeToString(String.valueOf(id).getBytes());
    }
}
