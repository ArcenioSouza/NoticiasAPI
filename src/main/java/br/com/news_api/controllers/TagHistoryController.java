package br.com.news_api.controllers;

import br.com.news_api.models.entity.TagHistory;
import br.com.news_api.services.TagHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tag-history")
public class TagHistoryController {
    private final TagHistoryService tagHistoryService;

    public TagHistoryController(TagHistoryService tagHistoryService) {
        this.tagHistoryService = tagHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<TagHistory>> getAll(){
        List<TagHistory> listTagHistory = tagHistoryService.findAll();
        return ResponseEntity.ok(listTagHistory);
    }
}
