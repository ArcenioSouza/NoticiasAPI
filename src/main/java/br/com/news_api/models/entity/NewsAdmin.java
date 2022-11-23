package br.com.news_api.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "NewsAdmin")
@Table(name = "news_admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class NewsAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
}
