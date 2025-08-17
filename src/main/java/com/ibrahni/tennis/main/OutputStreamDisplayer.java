package com.ibrahni.tennis.main;

import java.util.Map;
import java.util.stream.Collectors;

import com.ibrahni.tennis.domain.GameDisplayer;
import com.ibrahni.tennis.domain.Player;
import com.ibrahni.tennis.domain.score.ScoreValue;

public class OutputStreamDisplayer implements GameDisplayer {

    public void display(final String value) {
        System.out.println(value);
    }

    @Override
    public void displayScore(final Map<Player, ScoreValue> actualScore) {
        final String result = actualScore.entrySet()
            .stream()
            .map((entry) -> {
                return "%s : %s".formatted(entry.getKey()
                    .displayName(), entry.getValue()
                    .getValue());
            })
            .collect(Collectors.joining(" / "));

        display(result);
    }

    @Override
    public void displayWinner(final Player player) {
        display("%s wins the game".formatted(player.displayName()));
    }
}
