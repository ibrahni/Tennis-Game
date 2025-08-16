package com.ibrahni.tennis.domain;

import java.util.Map;

import com.ibrahni.tennis.domain.score.GameScore;
import com.ibrahni.tennis.domain.score.ScoreValue;

public interface GameDisplayer {

    void display(final String value);

    void display(final GameScore score);

    void display(final Map<Player, ScoreValue> score);

    void displayWinner(final Player winner);
}
