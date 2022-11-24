package br.com.news_api.controllers;

import br.com.news_api.models.dto.request.NewsTagRequestDto;
import br.com.news_api.models.dto.request.NewsTagUpdateRequestDto;
import br.com.news_api.models.dto.response.NewsTagResponseDto;
import br.com.news_api.services.NewsTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tag")
public class NewsTagController {

    private final NewsTagService newsTagService;

    public NewsTagController(NewsTagService newsTagService) {
        this.newsTagService = newsTagService;
    }

    @PostMapping
    @Transactional
    ResponseEntity<NewsTagResponseDto> post(@RequestBody NewsTagRequestDto newsTagRequestDto){
        NewsTagResponseDto newsTagResponseDto = newsTagService.save(newsTagRequestDto);
        return ResponseEntity.ok().body(newsTagResponseDto);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<NewsTagResponseDto>> getAll(){
        List<NewsTagResponseDto> listNewsTag = newsTagService.findAll();
        return ResponseEntity.ok().body(listNewsTag);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<NewsTagResponseDto> put(@RequestBody NewsTagUpdateRequestDto newsTagUpdateRequestDto){
        NewsTagResponseDto newsTagResponseDto = newsTagService.update(newsTagUpdateRequestDto);
        return ResponseEntity.ok().body(newsTagResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        newsTagService.delete(id);
        return ResponseEntity.ok().body("Successfully deleted record");
    }
}
