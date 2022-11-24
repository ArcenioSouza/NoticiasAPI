package br.com.news_api.controllers;

import br.com.news_api.models.dto.request.NewsUserRequestDto;
import br.com.news_api.models.dto.request.NewsUserUpdateRequestDto;
import br.com.news_api.models.dto.response.NewsUserResponseDto;
import br.com.news_api.services.NewsUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class NewsUserController {
    private final NewsUserService newsUserService;
    public NewsUserController(NewsUserService newsUserService) {
        this.newsUserService = newsUserService;
    }
    @PostMapping
    @Transactional
    public ResponseEntity<NewsUserResponseDto> post(@RequestBody NewsUserRequestDto newsUserRequestDto){
        NewsUserResponseDto newsUserResponseDto = newsUserService.save(newsUserRequestDto);
        return ResponseEntity.ok().body(newsUserResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<NewsUserResponseDto>> getAll(){
        List<NewsUserResponseDto> listNewsUserResponseDto = newsUserService.findAll();
        return ResponseEntity.ok().body(listNewsUserResponseDto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<NewsUserResponseDto> put(@RequestBody NewsUserUpdateRequestDto newsUserUpdateRequestDto){
        NewsUserResponseDto newsUserResponseDto = newsUserService.update(newsUserUpdateRequestDto);
        return ResponseEntity.ok().body(newsUserResponseDto);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id){
        newsUserService.delete(id);
        return ResponseEntity.ok().body("Excluido com sucesso");
    }
}
