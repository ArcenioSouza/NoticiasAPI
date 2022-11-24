package br.com.news_api.controllers;

import br.com.news_api.models.entity.News;
import br.com.news_api.services.NewsSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/news")
public class NewsSearchController {
    private final NewsSearchService newsSearchService;

    public NewsSearchController(NewsSearchService newsSearchService) {
        this.newsSearchService = newsSearchService;
    }


    @GetMapping("/tag")
    public ResponseEntity<News> getNewsByTag(@RequestParam Long tagId){
        News newsResponse = newsSearchService.newsSearchByTag(tagId);
        return ResponseEntity.ok(newsResponse);
    }

    @GetMapping("/parameters")
    public ResponseEntity<News> getNewsByParameters(@RequestParam String search, String date){
        News newsResponse = newsSearchService.newsSearchByParameters(search, date);
        return ResponseEntity.ok(newsResponse);
    }

}
