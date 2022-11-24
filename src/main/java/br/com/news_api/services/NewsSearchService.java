package br.com.news_api.services;

import br.com.news_api.models.entity.News;
import br.com.news_api.models.entity.NewsTag;
import br.com.news_api.models.repository.NewsTagRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Service
public class NewsSearchService {
    private final String baseUrl = "https://apinoticias.tedk.com.br";
    private final String uri = "/api/?q={search}&date={date}";
    private NewsTagRepository tagRepository;

    public NewsSearchService(NewsTagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public News newsSearchByTag(Long tagId) {
        NewsTag newsTag = tagRepository.findById(tagId).get();
        Date convertToDate = Date.valueOf(newsTag.getDate());
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        String date = formater.format(convertToDate);

        return WebClient.create(baseUrl)
                .get()
                .uri(uri, newsTag.getParameter(), date)
                .retrieve()
                .bodyToMono(News.class).block();
    }

    public News newsSearchByParameters(String search, String date) {
        return WebClient.create(baseUrl)
                        .get()
                        .uri(uri, search, date)
                        .retrieve()
                        .bodyToMono(News.class).block();
    }
}
