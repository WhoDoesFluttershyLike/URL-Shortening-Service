package com.example.URL.Shortening.Service.repository;

import com.example.URL.Shortening.Service.entity.UrlMapping;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;


@org.springframework.stereotype.Repository
public interface UrlRepository extends MongoRepository<UrlMapping, String> {

    @Query("{ 'shortUrl' : ?0 }")
    Optional<UrlMapping> findByShortUrl(String shortUrl);
}
