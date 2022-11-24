package br.com.news_api.controllers;

import br.com.news_api.models.dto.request.NewsAdminRequestDto;
import br.com.news_api.models.dto.request.NewsAdminUpdateRequestDto;
import br.com.news_api.models.dto.request.NewsUserRequestDto;
import br.com.news_api.models.dto.request.NewsUserUpdateRequestDto;
import br.com.news_api.models.dto.response.NewsAdminResponseDto;
import br.com.news_api.models.dto.response.NewsUserResponseDto;
import br.com.news_api.services.NewsAdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class NewsAdminController {
    private final NewsAdminService newsAdminService;
    public NewsAdminController(NewsAdminService newsAdminService) {
        this.newsAdminService = newsAdminService;
    }
    @PostMapping
    @Transactional
    public ResponseEntity<NewsAdminResponseDto> post(@RequestBody NewsAdminRequestDto newsAdminRequestDto){
        NewsAdminResponseDto newsAdminResponseDto = newsAdminService.save(newsAdminRequestDto);
        return ResponseEntity.ok().body(newsAdminResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<NewsAdminResponseDto>> getAll(){
        List<NewsAdminResponseDto> listNewsAdminResponseDto = newsAdminService.findAll();
        return ResponseEntity.ok().body(listNewsAdminResponseDto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<NewsAdminResponseDto> put(@RequestBody NewsAdminUpdateRequestDto newsAdminUpdateRequestDto){
        NewsAdminResponseDto newsAdminResponseDto = newsAdminService.update(newsAdminUpdateRequestDto);
        return ResponseEntity.ok().body(newsAdminResponseDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id){
        newsAdminService.delete(id);
        return ResponseEntity.ok().body("Successfully deleted record");
    }
}
