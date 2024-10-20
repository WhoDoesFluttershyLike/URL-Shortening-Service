package com.example.URL.Shortening.Service.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "urlmapping")
public class UrlMapping {
    private String id;

    private String originalUrl;
    @Indexed(unique = true)
    private String shortUrl;

    private LocalDateTime createdAt;
}
