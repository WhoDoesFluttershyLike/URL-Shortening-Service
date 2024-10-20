package com.example.URL.Shortening.Service.controller;


import com.example.URL.Shortening.Service.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class Controller {
    @Autowired
    private final UrlService urlService;

    public Controller(UrlService urlService) {
        this.urlService = urlService;
    }
    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestParam String originalUrl) {
        String shortUrl = urlService.shortenUrl(originalUrl);
        return ResponseEntity.ok(shortUrl);
    }

    @RequestMapping ("/{shortUrl}")
    public RedirectView redirectToOriginalUrl(@PathVariable String shortUrl) {
        return urlService.redirectToOriginalUrl(shortUrl);
    }

    @RequestMapping("/**")
    public RedirectView handleAll() {
        return new RedirectView("/error");
    }


}
