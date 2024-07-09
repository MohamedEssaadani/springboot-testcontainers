package org.essaadani.springbootestcontainers.service;

import org.essaadani.springbootestcontainers.entity.Player;

import java.util.List;

public interface PlayerService {
    List<Player> findAll();

    void saveAll(List<Player> players);

    void deleteAll();
}
