package org.essaadani.springbootestcontainers.service;

import org.essaadani.springbootestcontainers.entity.Player;
import org.essaadani.springbootestcontainers.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository repository;

    public PlayerServiceImpl(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Player> findAll() {
        return repository.findAll();
    }

    @Override
    public void saveAll(List<Player> players) {
        repository.saveAll(players);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
