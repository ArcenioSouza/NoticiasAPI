package br.com.news_api.controllers;

import br.com.news_api.models.dto.request.NewsTagRequestDto;
import br.com.news_api.models.entity.NewsTag;
import br.com.news_api.models.entity.NewsUser;
import br.com.news_api.models.repository.NewsTagRepository;
import br.com.news_api.models.repository.NewsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/tag")
public class NewsTagController {

    @Autowired
    private NewsTagRepository newsTagRepository;
    @Autowired
    private NewsUserRepository newsUserRepository;

    @PostMapping
    @Transactional
    ResponseEntity<NewsTag> post(@RequestBody NewsTagRequestDto newsTagRequestDto){
        NewsUser newsUser = newsUserRepository.findById(newsTagRequestDto.userId()).get();
        NewsTag newsTag = new NewsTag(newsTagRequestDto);
        newsTag.setNewsUser(newsUser);
        NewsTag dataNewsTag = newsTagRepository.save(newsTag);
        return ResponseEntity.ok().body(dataNewsTag);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<NewsTag>> getAll(){
        List<NewsTag> listNewsTag = newsTagRepository.findAll();
        return ResponseEntity.ok().body(listNewsTag);
    }
}
