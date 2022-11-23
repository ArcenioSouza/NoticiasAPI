package br.com.news_api.models.entity;

import br.com.news_api.models.dto.request.NewsTagRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    private Date date;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "news_user_id")
    private NewsUser newsUser;

    public NewsTag(NewsTagRequestDto newsTagRequestDto) {
        this.parameter = newsTagRequestDto.parameter();
        this.date = newsTagRequestDto.date();
    }
}
