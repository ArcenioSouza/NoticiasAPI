package br.com.news_api.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "NewsUser")
@Table(name = "news_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class NewsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    @OneToMany(mappedBy = "newsUser")
    private List<NewsTag> newsTagList;
}
