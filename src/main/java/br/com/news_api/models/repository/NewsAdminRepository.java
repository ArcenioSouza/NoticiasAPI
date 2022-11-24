package br.com.news_api.models.repository;

import br.com.news_api.models.entity.NewsAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsAdminRepository extends JpaRepository<NewsAdmin, Long> {

}
