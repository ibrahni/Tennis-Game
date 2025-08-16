package com.ibrahni.tennis.domain.score;

import java.util.Map;

import com.ibrahni.tennis.domain.GameDisplayer;
import com.ibrahni.tennis.domain.Player;
import com.ibrahni.tennis.domain.TennisGameException;

public class FinalScore extends IncrementalScore {

    protected final static String GAME_ENDED_ERROR_MESSAGE = "Game ended, score cannot change";
    private final Player winner;

    public FinalScore(Map<Player, ScoreValue> score, Player winner) {
        super(score);
        this.winner = winner;
    }

    @Override
    public GameScore increment(Player player) {
        throw new TennisGameException(GAME_ENDED_ERROR_MESSAGE);
    }

    @Override
    public void display(GameDisplayer displayer) {
        displayer.displayWinner(winner);
    }

    public Player getWinner() {
        return winner;
    }
}
