package ru.netology.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

    private Collection<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    //добавление игрока на турнир
    public void register(Player player) {
        players.add(player);
    }

    //получить список игроков
    public Collection<Player> findAll() {
        return players;
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        //проверка, зарегистрирован ли игрок?
        if (findByName(playerName1) == null && findByName(playerName2) == null) {
            throw new NotRegisteredException("Players " + playerName1 + ", " + playerName2 + " not registered");
        }
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Player name " + playerName1 + " not registered");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Player name " + playerName2 + " not registered");
        }

        //вычисление победителя
        if (findByName(playerName1).getStrength() - findByName(playerName2).getStrength() == 0) {
            return 0;
        }
        if (findByName(playerName1).getStrength() - findByName(playerName2).getStrength() > 0) {
            return 1;
        } else {
            return 2;
        }
    }
}
