package br.com.news_api.services;

import br.com.news_api.models.entity.TagHistory;
import br.com.news_api.models.repository.TagHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagHistoryService {
    private final TagHistoryRepository repository;

    public TagHistoryService(TagHistoryRepository repository) {
        this.repository = repository;
    }

    public List<TagHistory> findAll(){
        return repository.findAll();
    }


}
