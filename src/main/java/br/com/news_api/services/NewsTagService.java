package br.com.news_api.services;

import br.com.news_api.models.dto.request.NewsTagRequestDto;
import br.com.news_api.models.dto.request.NewsTagUpdateRequestDto;
import br.com.news_api.models.dto.response.NewsTagResponseDto;
import br.com.news_api.models.entity.NewsTag;
import br.com.news_api.models.entity.NewsUser;
import br.com.news_api.models.repository.NewsTagRepository;
import br.com.news_api.models.repository.NewsUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsTagService {
    private final NewsTagRepository tagRepository;
    private final NewsUserRepository userRepository;

    public NewsTagService(NewsTagRepository tagRepository, NewsUserRepository userRepository) {
        this.tagRepository = tagRepository;
        this.userRepository = userRepository;
    }

    public void delete(Long id) {
        tagRepository.deleteById(id);
    }

    public NewsTagResponseDto save(NewsTagRequestDto newsTagRequestDto){
        NewsUser newsUser = userRepository.findById(newsTagRequestDto.userId()).get();
        NewsTag newsTag = new NewsTag(newsTagRequestDto);
        newsTag.setNewsUser(newsUser);
        NewsTag dataNewsTag = tagRepository.save(newsTag);
        return new NewsTagResponseDto(dataNewsTag);
    }
    public List<NewsTagResponseDto> findAll(){
        return tagRepository.findAll().stream().map(NewsTagResponseDto::new).toList();
    }

    public NewsTagResponseDto update(NewsTagUpdateRequestDto newsTagUpdateRequestDto){
        NewsTag newsTag = tagRepository.findById(newsTagUpdateRequestDto.id()).get();
        newsTag.updateNewsUser(newsTagUpdateRequestDto);
        return new NewsTagResponseDto(newsTag);
    }
}
