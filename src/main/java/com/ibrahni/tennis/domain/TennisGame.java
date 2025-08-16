package com.ibrahni.tennis.domain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

import com.ibrahni.tennis.domain.score.FinalScore;
import com.ibrahni.tennis.domain.score.GameScore;
import com.ibrahni.tennis.domain.score.IncrementalScore;

public class TennisGame {

    protected static final String GAME_FINISHED_ERROR_MESSAGE = "Game Finished";
    protected static final String PLAYER_NOT_IN_THE_GAME_ERROR_MESSAGE = "Player not in the game";

    private final Player player1;
    private final Player player2;

    private final Deque<GameScore> scores = new ArrayDeque<>();

    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        scores.push(new IncrementalScore(player1, player2));
    }

    public Boolean finished() {
        return scores.peek() instanceof FinalScore;
    }

    public void roundWin(Player player) {
        if (finished()) {
            throw new TennisGameException(GAME_FINISHED_ERROR_MESSAGE);
        }

        if (existsInTheGame(player)) {
            scores.push(scores.peek()
                .increment(player));
        } else {
            throw new TennisGameException(PLAYER_NOT_IN_THE_GAME_ERROR_MESSAGE);
        }
    }

    private boolean existsInTheGame(Player player) {
        return Objects.equals(player1.name(), player.name()) || Objects.equals(player2.name(), player.name());
    }

    public void displayActualState(GameDisplayer gameDisplayer) {
        gameDisplayer.display(scores.peek());
    }

}
