package br.com.news_api.models.repository;

import br.com.news_api.models.entity.NewsAdmin;
import br.com.news_api.models.entity.NewsTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsAdminRepository extends JpaRepository<NewsAdmin, Long> {

}
