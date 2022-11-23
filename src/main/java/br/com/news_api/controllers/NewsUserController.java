package br.com.news_api.controllers;

import br.com.news_api.models.entity.NewsUser;
import br.com.news_api.models.repository.NewsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class NewsUserController {

    @Autowired
    private NewsUserRepository newsUserRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<NewsUser> post(@RequestBody NewsUser newsUser){
        NewsUser user = newsUserRepository.save(newsUser);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<List<NewsUser>> getAll(){
        List<NewsUser> newsUserList = newsUserRepository.findAll();
        return ResponseEntity.ok().body(newsUserList);
    }
}
