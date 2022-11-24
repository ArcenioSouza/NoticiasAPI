package br.com.news_api.models.dto.request;

import java.time.LocalDate;

public record NewsTagRequestDto(String parameter, LocalDate date, Long userId) {
}
