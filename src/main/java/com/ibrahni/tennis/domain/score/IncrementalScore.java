package com.ibrahni.tennis.domain.score;

import static com.ibrahni.tennis.domain.score.ScoreValue.FIFTEEN;
import static com.ibrahni.tennis.domain.score.ScoreValue.FORTY;
import static com.ibrahni.tennis.domain.score.ScoreValue.THIRTY;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ibrahni.tennis.domain.GameDisplayer;
import com.ibrahni.tennis.domain.Player;

public class IncrementalScore implements GameScore {

    protected Map<Player, ScoreValue> actualScore = new LinkedHashMap<>();

    public IncrementalScore(Player player1, Player player2) {
        actualScore.put(player1, ScoreValue.LOVE);
        actualScore.put(player2, ScoreValue.LOVE);
    }

    protected IncrementalScore(Map<Player, ScoreValue> score) {
        this.actualScore = new LinkedHashMap<>(score);
    }

    @Override
    public GameScore increment(Player player) {
        final ScoreValue existingScore = actualScore.get(player);

        final ScoreValue newScore = switch (existingScore) {
            case LOVE -> FIFTEEN;
            case FIFTEEN -> THIRTY;
            default -> FORTY;
        };

        final Map<Player, ScoreValue> mapScore = new LinkedHashMap<>(actualScore);
        mapScore.put(player, newScore);

        if (newScore == existingScore) {
            return new FinalScore(mapScore, player);
        }
        return new IncrementalScore(mapScore);
    }

    @Override
    public void display(GameDisplayer displayer) {
        displayer.display(Collections.unmodifiableMap(new LinkedHashMap<>(actualScore)));
    }
}
