package br.com.news_api.models.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public record NewsTagRequestDto(String parameter, Date date, Long userId) {
}
