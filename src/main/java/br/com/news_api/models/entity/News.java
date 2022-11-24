package br.com.news_api.models.entity;

import br.com.news_api.models.dto.response.NewsListResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class News {
    private int count;
    private List<NewsListResponseDto> list;
}
