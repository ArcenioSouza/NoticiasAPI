package br.com.news_api.models.dto.response;

import br.com.news_api.models.entity.NewsAdmin;
import br.com.news_api.models.entity.NewsTag;
import br.com.news_api.models.entity.NewsUser;

import java.util.List;

public record NewsAdminResponseDto(Long id, String username, String email) {

    public NewsAdminResponseDto(NewsAdmin newsAdmin){
        this(newsAdmin.getId(), newsAdmin.getUsername(), newsAdmin.getEmail());
    }
}
