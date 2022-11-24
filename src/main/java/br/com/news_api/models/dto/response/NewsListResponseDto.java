package br.com.news_api.models.dto.response;

public record NewsListResponseDto(String title, String description, String link, String datetime, String date,
                                  String time) {
}
