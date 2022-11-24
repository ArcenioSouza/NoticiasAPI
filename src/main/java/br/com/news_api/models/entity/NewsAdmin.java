package br.com.news_api.models.entity;

import br.com.news_api.models.dto.request.NewsAdminRequestDto;
import br.com.news_api.models.dto.request.NewsAdminUpdateRequestDto;
import br.com.news_api.models.dto.request.NewsUserRequestDto;
import br.com.news_api.models.dto.request.NewsUserUpdateRequestDto;
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

    public NewsAdmin(NewsAdminRequestDto newsAdminRequestDto) {
        this.username = newsAdminRequestDto.username();
        this.email = newsAdminRequestDto.email();
        this.password = newsAdminRequestDto.password();
    }

    public void updateNewsAdmin(NewsAdminUpdateRequestDto newsAdminUpdateRequestDto){
        this.username = newsAdminUpdateRequestDto.username() != null ? newsAdminUpdateRequestDto.username() : this.username;
        this.email = newsAdminUpdateRequestDto.email() != null ? newsAdminUpdateRequestDto.email() : this.email;
        this.password = newsAdminUpdateRequestDto.password() != null ? newsAdminUpdateRequestDto.password() : this.password;
    }
}
