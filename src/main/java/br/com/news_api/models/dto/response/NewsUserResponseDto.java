package br.com.news_api.models.dto.response;

import br.com.news_api.models.entity.NewsTag;
import br.com.news_api.models.entity.NewsUser;

import java.util.List;

public record NewsUserResponseDto(Long id, String username, String email, List<NewsTag> listNewsTag) {

    public NewsUserResponseDto(NewsUser newsUser){
        this(newsUser.getId(), newsUser.getUsername(), newsUser.getEmail(), newsUser.getNewsTagList());
    }
}
