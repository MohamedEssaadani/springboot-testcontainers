package org.essaadani.springbootestcontainers.api;

import org.essaadani.springbootestcontainers.entity.Player;
import org.essaadani.springbootestcontainers.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerRestAPI {
    private final PlayerService service;

    public PlayerRestAPI(PlayerService service) {
        this.service = service;
    }

    @GetMapping("/api/players")
    List<Player> playerList() {
        return service.findAll();
    }
}
