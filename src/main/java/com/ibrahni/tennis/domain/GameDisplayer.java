package com.ibrahni.tennis.domain;

import java.util.Map;

import com.ibrahni.tennis.domain.score.ScoreValue;

public interface GameDisplayer {

    void display(final Map<Player, ScoreValue> score);

    void display(final Player winner);
}
