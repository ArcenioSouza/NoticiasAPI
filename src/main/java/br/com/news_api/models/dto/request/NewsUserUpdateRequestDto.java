package br.com.news_api.models.dto.request;

public record NewsUserUpdateRequestDto(Long id, String username, String email, String password) {

}
