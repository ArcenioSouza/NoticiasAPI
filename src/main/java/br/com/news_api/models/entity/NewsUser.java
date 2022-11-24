package br.com.news_api.models.entity;

import br.com.news_api.models.dto.request.NewsUserRequestDto;
import br.com.news_api.models.dto.request.NewsUserUpdateRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "NewsAdmin")
@Table(name = "news_admin")
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

    public NewsUser(NewsUserRequestDto newsUserRequestDto) {
        this.username = newsUserRequestDto.username();
        this.email = newsUserRequestDto.email();
        this.password = newsUserRequestDto.password();
    }

    public void updateNewsUser(NewsUserUpdateRequestDto newsUserUpdateRequestDto){
        this.username = newsUserUpdateRequestDto.username() != null ? newsUserUpdateRequestDto.username() : this.username;
        this.email = newsUserUpdateRequestDto.email() != null ? newsUserUpdateRequestDto.email() : this.email;
        this.password = newsUserUpdateRequestDto.password() != null ? newsUserUpdateRequestDto.password() : this.password;
    }
}
