package br.com.news_api.services;

import br.com.news_api.models.dto.request.NewsAdminRequestDto;
import br.com.news_api.models.dto.request.NewsAdminUpdateRequestDto;
import br.com.news_api.models.dto.request.NewsUserRequestDto;
import br.com.news_api.models.dto.request.NewsUserUpdateRequestDto;
import br.com.news_api.models.dto.response.NewsAdminResponseDto;
import br.com.news_api.models.entity.NewsAdmin;
import br.com.news_api.models.entity.NewsUser;
import br.com.news_api.models.repository.NewsAdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsAdminService {
    private final NewsAdminRepository repository;

    public NewsAdminService(NewsAdminRepository repository) {
        this.repository = repository;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public NewsAdminResponseDto save(NewsAdminRequestDto newsAdminRequestDto){
        NewsAdmin newsAdmin = repository.save(new NewsAdmin(newsAdminRequestDto));
        return new NewsAdminResponseDto(newsAdmin);
    }

    public List<NewsAdminResponseDto> findAll(){
        return repository.findAll().stream().map(NewsAdminResponseDto::new).toList();
    }

    public NewsAdminResponseDto update(NewsAdminUpdateRequestDto newsAdminUpdateRequestDto){
        NewsAdmin newsAdmin = repository.findById(newsAdminUpdateRequestDto.id()).get();
        newsAdmin.updateNewsAdmin(newsAdminUpdateRequestDto);
        return new NewsAdminResponseDto(newsAdmin);
    }
}
