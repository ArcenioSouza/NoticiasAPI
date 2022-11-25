package br.com.news_api.controllers;

import br.com.news_api.models.entity.ParameterHistory;
import br.com.news_api.models.entity.TagHistory;
import br.com.news_api.services.ParameterHistoryService;
import br.com.news_api.services.TagHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/parameter-history")
public class ParameterHistoryController {
    private final ParameterHistoryService parameterHistoryService;

    public ParameterHistoryController(ParameterHistoryService parameterHistoryService) {
        this.parameterHistoryService = parameterHistoryService;
    }

    @GetMapping
    public ResponseEntity<List<ParameterHistory>> getAll(){
        List<ParameterHistory> listParameterHistory = parameterHistoryService.findAll();
        return ResponseEntity.ok(listParameterHistory);
    }
}
