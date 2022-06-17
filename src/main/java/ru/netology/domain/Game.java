package ru.netology.domain;

import java.util.*;

public class Game {

    private HashMap<String, Player> players;

    public Game() {
        this.players = new LinkedHashMap<>();
    }

    //добавление игрока на турнир
    public void register(Player player) {
        players.put(player.getName(), player);
    }

    //получить список игроков
    public Collection<Player> findAll() {
        return new ArrayList<>(players.values());
    }

    //public Player findByName(String playerName) {
    //    for (Player player : players) {
    //        if (player.getName() == playerName) {
    //            return player;
    //        }
    //    }
    //     return null;
    //}

    public int round(String playerName1, String playerName2) {
        //проверка, зарегистрирован ли игрок?
        if (!players.containsKey(playerName1) && !players.containsKey(playerName2)) {
            throw new NotRegisteredException("Players " + playerName1 + ", " + playerName2 + " not registered");
        }
        if (!players.containsKey(playerName1)) {
            throw new NotRegisteredException("Player name " + playerName1 + " not registered");
        }
        if (!players.containsKey(playerName2)) {
            throw new NotRegisteredException("Player name " + playerName2 + " not registered");
        }

        //вычисление победителя
        if (players.get(playerName1).getStrength() - players.get(playerName2).getStrength() == 0) {
            return 0;
        }
        if (players.get(playerName1).getStrength() - players.get(playerName2).getStrength() > 0) {
            return 1;
        } else {
            return 2;
        }
    }
}
