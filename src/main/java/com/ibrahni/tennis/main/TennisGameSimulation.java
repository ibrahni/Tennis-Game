package com.ibrahni.tennis.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ibrahni.tennis.domain.GameDisplayer;
import com.ibrahni.tennis.domain.Player;
import com.ibrahni.tennis.domain.TennisGame;

public class TennisGameSimulation {

    private final GameDisplayer gameDisplayer;
    private final Map<String, Player> players;

    public TennisGameSimulation(GameDisplayer gameDisplayer, Player player1, Player player2) {
        this.gameDisplayer = gameDisplayer;
        this.players = new LinkedHashMap<>() {{
            put(player1.name(), player1);
            put(player2.name(), player2);
        }};
    }

    public void simulate(final String gameWins) {
        final TennisGame tennisGame = createNewTennisGame();

        final Iterator<Player> iterator = getWins(gameWins, players).iterator();
        while (!tennisGame.finished() && iterator.hasNext()) {
            tennisGame.roundWin(iterator.next());
            tennisGame.displayActualState(gameDisplayer);
        }
    }

    private TennisGame createNewTennisGame() {
        final List<Player> playerList = new ArrayList<>(players.values());

        return new TennisGame(playerList.getFirst(), playerList.getLast());
    }

    static List<Player> getWins(String gameWins, Map<String, Player> players) {
        return gameWins.chars()
            .mapToObj(value -> String.valueOf((char) value))
            .map(players::get)
            .toList();
    }
}
