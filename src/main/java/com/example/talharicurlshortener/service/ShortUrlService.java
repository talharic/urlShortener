package com.example.talharicurlshortener.service;

import com.example.talharicurlshortener.model.ShortUrl;
import com.example.talharicurlshortener.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlService {
    private final ShortUrlRepository repository;

    public ShortUrlService(ShortUrlRepository repository) {
        this.repository = repository;
    }

    public List<ShortUrl> getAllShortUrl() {
        return repository.findAll();
    }

    public ShortUrl getUrlByCode(String code) {
        return repository.findAllByCode(code).orElseThrow(() -> new RuntimeException("Bulunamadı"));
    }

    public ShortUrl create(ShortUrl shortUrl) {
        if(shortUrl.getCode() == null || shortUrl.getCode().isEmpty()){
            shortUrl.setCode(generateCode());
        }
        else if(repository.findAllByCode(shortUrl.getCode()).isPresent()){
            throw new RuntimeException("Aynısından zaten var");
        }
        shortUrl.setCode(shortUrl.getCode().toUpperCase());
        return repository.save(shortUrl);
    }

    private String generateCode(){
        return null;
    }
}
