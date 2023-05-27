package br.com.qwasolucoes.workshop.githubactions.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
}
