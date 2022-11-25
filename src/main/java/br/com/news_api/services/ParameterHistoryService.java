package br.com.news_api.services;

import br.com.news_api.models.entity.ParameterHistory;
import br.com.news_api.models.repository.ParameterHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParameterHistoryService {
    private final ParameterHistoryRepository repository;

    public ParameterHistoryService(ParameterHistoryRepository repository) {
        this.repository = repository;
    }

    public List<ParameterHistory> findAll(){
        return repository.findAll();
    }
}
