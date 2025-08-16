package com.ibrahni.tennis.domain.score;

import java.util.Map;
import java.util.Objects;

import com.ibrahni.tennis.domain.Player;

public class AdvantageScore extends IncrementalScore {

    private final Player advantageousPlayer;

    public AdvantageScore(Map<Player, ScoreValue> score, Player advantageous) {
        super(score);
        this.advantageousPlayer = advantageous;
    }

    @Override
    public GameScore increment(Player player) {
        if (Objects.equals(player, advantageousPlayer)) {
            return new FinalScore(actualScore, advantageousPlayer);
        } else {
            return new DeuceScore(actualScore);
        }
    }

    public Player getAdvantageousPlayer() {
        return advantageousPlayer;
    }
}
