package br.com.news_api.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parameter_history")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParameterHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String parameter;

    public ParameterHistory(String parameter) {
        this.parameter = parameter;
    }
}
