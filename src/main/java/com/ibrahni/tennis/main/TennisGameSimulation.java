package com.ibrahni.tennis.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ibrahni.tennis.domain.GameDisplayer;
import com.ibrahni.tennis.domain.Player;
import com.ibrahni.tennis.domain.TennisGame;

public class TennisGameSimulation {

    private final GameDisplayer gameDisplayer;

    public TennisGameSimulation(GameDisplayer gameDisplayer) {
        this.gameDisplayer = gameDisplayer;
    }

    public void simulate(final String gameWins, final String player1, final String player2) {
        final Map<String, Player> players = Map.of(player1, new Player(player1), player2, new Player(player2));
        final TennisGame tennisGame = new TennisGame(players.get(player1), players.get(player2));

        final Iterator<Player> iterator = getWins(gameWins, players).iterator();
        while (!tennisGame.finished() && iterator.hasNext()) {
            tennisGame.roundWin(iterator.next());
            tennisGame.displayActualState(gameDisplayer);
        }
    }

    static List<Player> getWins(String gameWins, Map<String, Player> players) {
        return gameWins.chars()
            .mapToObj(value -> String.valueOf((char) value))
            .map(players::get)
            .toList();
    }
}
