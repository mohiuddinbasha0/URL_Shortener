package com.project.URL.Shortener.Services;

import com.project.URL.Shortener.Exceptions.URINotFoundException;
import com.project.URL.Shortener.Models.LongURL;
import com.project.URL.Shortener.Repositories.LongURLRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;

@Service
public class LongURLServiceImpl implements LongURLService{

    private LongURLRepository longURLRepository;

    LongURLServiceImpl(LongURLRepository longURLRepository) {
        this.longURLRepository = longURLRepository;
    }

    @Override
    public ResponseEntity<Object> getLongURL(String shortURI) {
        try {
            Long id = decodePath(shortURI);

            Optional<LongURL> optionalLongURL = longURLRepository.findById(id);

            if(optionalLongURL.isPresent()) {
                return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(optionalLongURL.get().getUrl())).build();
            } else {
                throw new URINotFoundException("URI does not exist");
            }
        } catch (URINotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private Long decodePath(String shortUrl){
        byte[] bytes = Base64.getDecoder().decode(shortUrl.getBytes());
        String str = new String(bytes, StandardCharsets.UTF_8);
        return Long.parseLong(str);
    }
}
