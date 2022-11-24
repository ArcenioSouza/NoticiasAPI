package br.com.news_api.models.dto.request;

public record NewsAdminUpdateRequestDto(Long id, String username, String email, String password) {

}
