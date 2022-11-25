package br.com.news_api.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tag_history")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TagHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private NewsTag newsTag;

    public TagHistory(NewsTag newsTag) {
        this.newsTag = new NewsTag(newsTag);
    }
}
