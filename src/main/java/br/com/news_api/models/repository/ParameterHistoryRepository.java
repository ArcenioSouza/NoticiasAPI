package br.com.news_api.models.repository;

import br.com.news_api.models.entity.ParameterHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterHistoryRepository extends JpaRepository<ParameterHistory, Long> {

}
