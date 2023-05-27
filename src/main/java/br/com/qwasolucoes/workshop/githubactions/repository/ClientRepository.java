package br.com.qwasolucoes.workshop.githubactions.repository;

import br.com.qwasolucoes.workshop.githubactions.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
