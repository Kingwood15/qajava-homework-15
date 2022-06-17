package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class GameTest {

    @Test
    void shouldEmptyPlayers() {
        Game players = new Game();

        Collection<Player> actual = players.findAll();
        Collection<Player> expected = List.of();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldOnePlayer() {
        Player player1 = new Player(1, "Sam", 1);
        Game players = new Game();

        players.register(player1);

        Collection<Player> actual = players.findAll();
        Collection<Player> expected = List.of(player1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldMorePlayers() {
        Player player1 = new Player(1, "Ivan", 5);
        Player player2 = new Player(2, "Sergey", 10);
        Player player3 = new Player(3, "Alexandr", 15);
        Player player4 = new Player(4, "Vladimir", 20);
        Player player5 = new Player(5, "Dmitry", 15);
        Player player6 = new Player(6, "Anton", 12);
        Player player7 = new Player(7, "Anya", 7);
        Player player8 = new Player(8, "Svetlana", 5);
        Player player9 = new Player(9, "Masha", 30);
        Player player10 = new Player(10, "Irina", 2);
        Game players = new Game();

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);
        players.register(player7);
        players.register(player8);
        players.register(player9);
        players.register(player10);

        Collection<Player> actual = players.findAll();
        Collection<Player> expected = List.of(player1, player2, player3, player4, player5, player6, player7, player8, player9, player10);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldRoundRegisteredPlayers() {
        Player player1 = new Player(1, "Ivan", 5);
        Player player2 = new Player(2, "Sergey", 10);
        Player player3 = new Player(3, "Alexandr", 15);
        Player player4 = new Player(4, "Vladimir", 20);
        Player player5 = new Player(5, "Dmitry", 15);
        Player player6 = new Player(6, "Anton", 12);
        Player player7 = new Player(7, "Anya", 7);
        Player player8 = new Player(8, "Svetlana", 5);
        Player player9 = new Player(9, "Masha", 30);
        Player player10 = new Player(10, "Irina", 2);
        Game players = new Game();

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);
        players.register(player7);
        players.register(player8);
        players.register(player9);
        players.register(player10);


        int actual1 = players.round("Ivan", "Sergey");
        int expected1 = 2; // Ivan = 5, Sergey = 10

        Assertions.assertEquals(expected1, actual1);

        int actual2 = players.round("Alexandr", "Dmitry");
        int expected2 = 0; //Alexandr = 15, Dmitry = 15

        Assertions.assertEquals(expected2, actual2);

        int actual3 = players.round("Masha", "Anton");
        int expected3 = 1; //Masha = 30, Anton = 12

        Assertions.assertEquals(expected3, actual3);
    }

    @Test
    void shouldRoundNotRegisteredPlayers() {
        Player player1 = new Player(1, "Ivan", 5);
        Player player2 = new Player(2, "Sergey", 10);
        Player player3 = new Player(3, "Alexandr", 15);
        Player player4 = new Player(4, "Vladimir", 20);
        Player player5 = new Player(5, "Dmitry", 15);
        Player player6 = new Player(6, "Anton", 12);
        Player player7 = new Player(7, "Anya", 7);
        Player player8 = new Player(8, "Svetlana", 5);
        Player player9 = new Player(9, "Masha", 30);
        Player player10 = new Player(10, "Irina", 2);
        Game players = new Game();

        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);
        players.register(player7);
        players.register(player8);
        players.register(player9);
        players.register(player10);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Sam", "Sergey"); // Sam = null, Sergey = 10
        });

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Alexandr", "John"); // Alexandr = 15, John = null
        });

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Sam", "John"); // Sam = null, John = null
        });
    }
}
