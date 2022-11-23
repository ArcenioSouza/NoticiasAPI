package br.com.news_api.models.repository;

import br.com.news_api.models.entity.NewsTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsTagRepository extends JpaRepository<NewsTag, Long> {

}
