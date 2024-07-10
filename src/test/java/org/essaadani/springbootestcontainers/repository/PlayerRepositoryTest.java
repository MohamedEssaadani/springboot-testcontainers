package org.essaadani.springbootestcontainers.repository;

import org.essaadani.springbootestcontainers.entity.Player;
import org.essaadani.springbootestcontainers.enums.PlayerPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

@Testcontainers
@DataJpaTest
// do not replace the testcontainer data source
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PlayerRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @Autowired
    private PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        Player kroos = new Player("Toni", "KROOS", PlayerPosition.CAM.name());
        Player modric = new Player("Luka", "MODRIC", PlayerPosition.CAM.name());
        playerRepository.saveAll(List.of(kroos, modric));

//        playerRepository.deleteAll();
    }

    @Test
    void testSaveAndFindPlayer() {
        Player player = new Player("Jude", "BELLINGHAM", PlayerPosition.CAM.name());
        Player savedPlayer = playerRepository.save(player);

        Optional<Player> foundPlayer = playerRepository.findById(savedPlayer.getId());

        assertThat(foundPlayer).isPresent();
        assertThat(foundPlayer.get().getFirstName()).isEqualTo("Jude");
    }

    @Test
    void testFindAllPlayers() {
        List<Player> playerList = playerRepository.findAll();

        assertThat(playerList.size()).isGreaterThan(0);
    }
}
