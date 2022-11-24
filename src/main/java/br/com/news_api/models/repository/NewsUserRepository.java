package br.com.news_api.models.repository;

import br.com.news_api.models.entity.NewsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsUserRepository extends JpaRepository<NewsUser, Long> {
}
