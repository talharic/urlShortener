package com.example.talharicurlshortener.dto.converter;

import com.example.talharicurlshortener.dto.ShortUrlDto;
import com.example.talharicurlshortener.model.ShortUrl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShortUrlDtoConverter {
    public ShortUrlDto convertToDto(ShortUrl shortUrl) {
        return ShortUrlDto.builder()
                .id(shortUrl.getId())
                .url(shortUrl.getUrl())
                .code(shortUrl.getCode())
                .build();
    }

    public List<ShortUrlDto> convertToDto(List<ShortUrl> shortUrl) {
        return shortUrl.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
