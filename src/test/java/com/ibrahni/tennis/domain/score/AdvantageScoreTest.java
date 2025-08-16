package com.ibrahni.tennis.domain.score;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.ibrahni.tennis.domain.Player;

class AdvantageScoreTest {

    @Test
    void givenAnAdvantageousScoreForAPlayer_whenSamePlayerScores_shouldReturnFinalScore() {
        final Player player1 = new Player("1");
        final Player player2 = new Player("2");
        final AdvantageScore score = new AdvantageScore(Map.of(player1, ScoreValue.FORTY, player2, ScoreValue.FORTY), player1);

        GameScore result = score.increment(player1);

        assertInstanceOf(FinalScore.class, result);
        assertEquals(player1, ((FinalScore) result).getWinner());
    }

    @Test
    void givenAnAdvantageousScoreForAPlayer_whenOtherPlayerScores_shouldReturnToDeuceScore() {
        final Player player1 = new Player("1");
        final Player player2 = new Player("2");
        final AdvantageScore score = new AdvantageScore(Map.of(player1, ScoreValue.FORTY, player2, ScoreValue.FORTY), player1);

        GameScore result = score.increment(player2);

        assertInstanceOf(DeuceScore.class, result);
    }
}