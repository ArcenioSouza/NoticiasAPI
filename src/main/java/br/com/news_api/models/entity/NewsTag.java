package br.com.news_api.models.entity;

import br.com.news_api.models.dto.request.NewsTagRequestDto;
import br.com.news_api.models.dto.request.NewsTagUpdateRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "NewsTag")
@Table(name = "news_tag")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class NewsTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String parameter;
    private LocalDate date;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "news_user_id")
    private NewsUser newsUser;

    public NewsTag(NewsTagRequestDto newsTagRequestDto) {
        this.parameter = newsTagRequestDto.parameter();
        this.date = newsTagRequestDto.date();
    }

    public NewsTag(NewsTag newsTag) {
        this.id = newsTag.getId();
        this.parameter = newsTag.getParameter();
        this.date = newsTag.getDate();
    }

    public void updateNewsUser(NewsTagUpdateRequestDto newsTagUpdateRequestDto) {
        this.parameter = newsTagUpdateRequestDto.parameter() != null ? newsTagUpdateRequestDto.parameter() : this.parameter;
        this.date = newsTagUpdateRequestDto.date() != null ? newsTagUpdateRequestDto.date() : this.date;
    }
}
