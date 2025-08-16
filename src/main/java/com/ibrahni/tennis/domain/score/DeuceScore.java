package com.ibrahni.tennis.domain.score;

import java.util.Map;

import com.ibrahni.tennis.domain.Player;

public class DeuceScore extends IncrementalScore {

    public DeuceScore(Map<Player, ScoreValue> score) {
        super(score);
    }

    @Override
    public GameScore increment(Player player) {
        return new AdvantageScore(this.actualScore, player);
    }

}
