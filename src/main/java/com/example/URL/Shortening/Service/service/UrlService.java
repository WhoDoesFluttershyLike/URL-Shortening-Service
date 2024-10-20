package com.example.URL.Shortening.Service.service;

import com.example.URL.Shortening.Service.entity.UrlMapping;
import com.example.URL.Shortening.Service.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {
    @Autowired
    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }


    public String shortenUrl(String originalUrl) {
        String shortUrl = generateShortUrl();
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setShortUrl(shortUrl);
        urlMapping.setCreatedAt(LocalDateTime.now());
        repository.save(urlMapping);
        return shortUrl;
    }

    private String generateShortUrl() {
        Random random = new Random();
        int leftLimit = 97; // 'a'
        int rightLimit = 122; // 'z'
        int targetStringLength = 6;
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public RedirectView redirectToOriginalUrl(String shortUrl) {
        Optional<UrlMapping> urlMapping = repository.findByShortUrl(shortUrl);
        return urlMapping.map(mapping -> new RedirectView(mapping.getOriginalUrl())).orElseGet(() -> new RedirectView("/error"));
    }
}
