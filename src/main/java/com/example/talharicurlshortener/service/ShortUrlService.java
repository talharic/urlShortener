package com.example.talharicurlshortener.service;

import com.example.talharicurlshortener.exception.CodeAlreadyExists;
import com.example.talharicurlshortener.exception.ShortUrlNotFoundException;
import com.example.talharicurlshortener.model.ShortUrl;
import com.example.talharicurlshortener.repository.ShortUrlRepository;
import com.example.talharicurlshortener.util.RandomStringGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlService {
    private final ShortUrlRepository repository;
    private final RandomStringGenerator randomStringGenerator;

    public ShortUrlService(ShortUrlRepository repository, RandomStringGenerator randomStringGenerator) {
        this.repository = repository;
        this.randomStringGenerator = randomStringGenerator;
    }

    public List<ShortUrl> getAllShortUrl() {
        return repository.findAll();
    }

    public ShortUrl getUrlByCode(String code) {
        return repository.findAllByCode(code).orElseThrow(() -> new ShortUrlNotFoundException("URL Bulunamadı!"));
    }

    public ShortUrl create(ShortUrl shortUrl) {
        if(shortUrl.getCode() == null || shortUrl.getCode().isEmpty()){
            shortUrl.setCode(generateCode());
        }
        else if(repository.findAllByCode(shortUrl.getCode()).isPresent()){
            throw new CodeAlreadyExists("Aynısından zaten var.");
        }
        shortUrl.setCode(shortUrl.getCode().toUpperCase());
        return repository.save(shortUrl);
    }

    private String generateCode(){
        String code;

        do{
            code = randomStringGenerator.generateRandomString();
        }
        while (repository.findAllByCode(code).isPresent());

        return code;
    }
}
