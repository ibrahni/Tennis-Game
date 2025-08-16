package com.ibrahni.tennis.domain.score;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.ibrahni.tennis.domain.Player;

class DeuceScoreTest {

    @Test
    void givenAnADeuceScore_whenAPlayerScores_shouldReturnAdvantageScoreForThatPlayer() {
        final Player player1 = new Player("1");
        final Player player2 = new Player("2");
        final DeuceScore score = new DeuceScore(Map.of(player1, ScoreValue.FORTY, player2, ScoreValue.FORTY));

        GameScore result = score.increment(player1);

        assertInstanceOf(AdvantageScore.class, result);
        assertEquals(player1, ((AdvantageScore) result).getAdvantageousPlayer());
    }
}