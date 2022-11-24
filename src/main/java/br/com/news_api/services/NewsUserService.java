package br.com.news_api.services;

import br.com.news_api.models.dto.request.NewsUserRequestDto;
import br.com.news_api.models.dto.request.NewsUserUpdateRequestDto;
import br.com.news_api.models.dto.response.NewsUserResponseDto;
import br.com.news_api.models.entity.NewsUser;
import br.com.news_api.models.repository.NewsUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsUserService {
    private final NewsUserRepository repository;

    public NewsUserService(NewsUserRepository repository) {
        this.repository = repository;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public NewsUserResponseDto save(NewsUserRequestDto newsUserRequestDto){
        NewsUser newsUser = repository.save(new NewsUser(newsUserRequestDto));
        return new NewsUserResponseDto(newsUser);
    }
    public List<NewsUserResponseDto> findAll(){
        return repository.findAll().stream().map(NewsUserResponseDto::new).toList();
    }

    public NewsUserResponseDto update(NewsUserUpdateRequestDto newsUserUpdateRequestDto){
        NewsUser newsUser = repository.findById(newsUserUpdateRequestDto.id()).get();
        newsUser.updateNewsUser(newsUserUpdateRequestDto);
        return new NewsUserResponseDto(newsUser);
    }
}
