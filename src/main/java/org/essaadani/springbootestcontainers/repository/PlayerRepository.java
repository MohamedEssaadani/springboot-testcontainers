package org.essaadani.springbootestcontainers.repository;

import org.essaadani.springbootestcontainers.entity.Player;
import org.springframework.data.repository.ListCrudRepository;

public interface PlayerRepository extends ListCrudRepository<Player, Long> {
}
