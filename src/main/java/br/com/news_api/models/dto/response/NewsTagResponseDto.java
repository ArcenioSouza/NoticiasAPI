package br.com.news_api.models.dto.response;

import br.com.news_api.models.entity.NewsTag;

import java.time.LocalDate;

public record NewsTagResponseDto(Long id, String parameter, LocalDate date) {

    public NewsTagResponseDto(NewsTag newsTag){
        this(newsTag.getId(), newsTag.getParameter(), newsTag.getDate());
    }
}
