package org.essaadani.springbootestcontainers.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.essaadani.springbootestcontainers.entity.Player;
import org.essaadani.springbootestcontainers.enums.PlayerPosition;
import org.essaadani.springbootestcontainers.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class PlayerRestAPITest {

    @LocalServerPort
    private Integer port;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @Autowired
    PlayerService service;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        service.deleteAll();
    }

    @Test
    void shouldGetAllPlayers() {
        // players of test
        List<Player> playerList = List.of(
                new Player("Sergio", "RAMOS", PlayerPosition.CB.toString()),
                new Player("Dani", "CARVAJAL", PlayerPosition.RB.toString()),
                new Player("Toni", "KROOS", PlayerPosition.LCM.toString())
        );

        // save players
        service.saveAll(playerList);

        // test api
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/players")
                .then()
                .statusCode(200)
                .body(".", hasSize(3));
    }
}
