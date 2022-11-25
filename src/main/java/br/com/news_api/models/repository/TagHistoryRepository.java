package br.com.news_api.models.repository;

import br.com.news_api.models.entity.TagHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagHistoryRepository extends JpaRepository<TagHistory, Long> {

}
