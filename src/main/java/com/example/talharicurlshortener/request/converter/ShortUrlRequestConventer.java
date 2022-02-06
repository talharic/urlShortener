package com.example.talharicurlshortener.request.converter;

import com.example.talharicurlshortener.model.ShortUrl;
import com.example.talharicurlshortener.request.ShortUrlRequest;
import org.springframework.stereotype.Component;

@Component
public class ShortUrlRequestConventer {
    public ShortUrl convertToEntity(ShortUrlRequest shortUrlRequest){
        return ShortUrl.builder()
                .url(shortUrlRequest.getUrl())
                .code(shortUrlRequest.getCode())
                .build();
    }
}
