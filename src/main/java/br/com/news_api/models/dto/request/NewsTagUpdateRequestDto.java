package br.com.news_api.models.dto.request;

import java.time.LocalDate;

public record NewsTagUpdateRequestDto(Long id, String parameter, LocalDate date) {
}
